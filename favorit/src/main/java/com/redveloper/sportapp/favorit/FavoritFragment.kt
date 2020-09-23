package com.redveloper.sportapp.favorit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.core.domain.model.Team
import com.redveloper.sportapp.favorit.di.favoritModule
import com.redveloper.sportapp.ui.detail.team.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_favorit.*
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class FavoritFragment : Fragment(), FavoritAdapter.FavoritAdapterImpl {

    val viewModel : FavoritViewModel by inject()
    private lateinit var favoritAdapter: FavoritAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorit, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        favoritAdapter = FavoritAdapter()
        favoritAdapter.setListener(this)

        loadKoinModules(favoritModule)

        with(rv_favorite){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = favoritAdapter
        }

        viewModel.team.observe(this, Observer { data ->
            if (!data.isNullOrEmpty()){
                tv_empty_data.visibility = View.GONE
                favoritAdapter.setData(data)
                favoritAdapter.notifyDataSetChanged()
            } else {
                tv_empty_data.visibility = View.VISIBLE
            }
        })
    }

    override fun onTeamClick(data: Team) {
        val intent = Intent(requireActivity(), DetailTeamActivity::class.java)
        intent.putExtra(DetailTeamActivity.EXTRAS, data)
        context?.startActivity(intent)
    }
}