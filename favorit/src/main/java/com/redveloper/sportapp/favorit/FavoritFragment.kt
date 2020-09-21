package com.redveloper.sportapp.favorit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.favorit.di.favoritModule
import kotlinx.android.synthetic.main.fragment_favorit.*
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class FavoritFragment : Fragment() {

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

        loadKoinModules(favoritModule)

        with(rv_favorite){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = favoritAdapter
        }

        viewModel.team.observe(this, Observer { data ->
            if (!data.isNullOrEmpty()){
                favoritAdapter.setData(data)
                favoritAdapter.notifyDataSetChanged()
            }
        })
    }
}