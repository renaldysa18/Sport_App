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
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoritFragment : Fragment(), FavoritAdapter.FavoritAdapterImpl {

    val favoritViewModel : FavoritViewModel by viewModel()
    private lateinit var favoritAdapter: FavoritAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            favoritAdapter = FavoritAdapter()
            favoritAdapter.setListener(this)

            loadKoinModules(favoritModule)

            with(rv_favorite){
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = favoritAdapter
            }

            favoritViewModel.team.observe(viewLifecycleOwner, Observer { data ->
                favoritAdapter.setData(data)
                tv_empty_data.visibility = if (data.isNotEmpty()) View.GONE else View.VISIBLE
            })
        }
    }

    override fun onTeamClick(data: Team) {
        val intent = Intent(requireActivity(), DetailTeamActivity::class.java)
        intent.putExtra(DetailTeamActivity.EXTRAS, data)
        context?.startActivity(intent)
    }
}