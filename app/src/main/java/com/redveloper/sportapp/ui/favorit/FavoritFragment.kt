package com.redveloper.sportapp.ui.favorit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorit.*

class FavoritFragment : Fragment() {

    private lateinit var viewModel : FavoritViewModel
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

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[FavoritViewModel::class.java]

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