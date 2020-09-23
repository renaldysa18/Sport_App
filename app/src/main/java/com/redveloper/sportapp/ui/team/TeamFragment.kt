package com.redveloper.sportapp.ui.team

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.domain.model.Team
import com.redveloper.sportapp.ui.detail.team.DetailTeamActivity
import com.redveloper.sportapp.core.utils.Constanta
import com.redveloper.sportapp.core.utils.toast
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.android.synthetic.main.fragment_team.*
import org.koin.android.viewmodel.ext.android.viewModel

class TeamFragment : Fragment(), TeamAdapter.TeamAdapterImpl {

    val teamViewModel: TeamViewModel by viewModel()
    private lateinit var teamAdapter: TeamAdapter
    private lateinit var progressDialog: ProgressDialog

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            teamAdapter = TeamAdapter()
            teamAdapter.setListener(this)
            progressDialog = ProgressDialog(requireActivity())

            with(rv_team){
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = teamAdapter
            }

            getDataTeam(Constanta.NAME_LEAGUE)
        }
    }

    override fun onTeamClicked(data: Team) {
        val intent = Intent(requireActivity(), DetailTeamActivity::class.java)
        intent.putExtra(DetailTeamActivity.EXTRAS, data)
        context?.startActivity(intent)
    }

    private fun getDataTeam(nameLeague : String){
        teamViewModel.getAllTeam(nameLeague).observe(viewLifecycleOwner, Observer { data ->
            if (data != null){
                when(data){
                    is Resource.Loading -> {
                        progressDialog.setMessage(resources.getString(R.string.loading))
                        progressDialog.show()
                    }
                    is Resource.Success -> {
                        showDataTeam(data.data)
                        progressDialog.dismiss()
                    }
                    is Resource.Error -> {
                        progressDialog.dismiss()
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