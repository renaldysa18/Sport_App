package com.redveloper.sportapp.ui.team

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.domain.model.Team
import com.redveloper.sportapp.ui.detail.team.DetailTeamActivity
import com.redveloper.sportapp.core.utils.Constanta
import com.redveloper.sportapp.core.utils.toast
import com.redveloper.sportapp.core.viewmodel.ViewModelFactory
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.android.synthetic.main.fragment_team.*

class TeamFragment : Fragment(), TeamAdapter.TeamAdapterImpl {

    private lateinit var viewModel: TeamViewModel
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamAdapter = TeamAdapter()
        teamAdapter.setListener(this)

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[TeamViewModel::class.java]

        with(rv_team){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = teamAdapter
        }

        getDataTeam(Constanta.NAME_LEAGUE)
    }

    override fun onTeamClicked(data: Team) {
        val intent = Intent(requireActivity(), DetailTeamActivity::class.java)
        intent.putExtra(DetailTeamActivity.EXTRAS, data)
        context?.startActivity(intent)
    }

    private fun getDataTeam(nameLeague : String){
        viewModel.getAllTeam(nameLeague).observe(this, Observer { data ->
            if (data != null){
                when(data){
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        showDataTeam(data.data)
                    }
                    is Resource.Error -> {
                        context?.toast(data.message.toString())
                    }
                }
            }
        })
    }

    private fun showDataTeam(data : List<Team>?){
        teamAdapter.setItemTeam(data)
        teamAdapter.notifyDataSetChanged()
    }

}