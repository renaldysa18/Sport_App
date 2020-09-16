package com.redveloper.sportapp.ui.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_match.*

class MatchFragment : Fragment() {

    private lateinit var matchViewModel: MatchViewModel
    private lateinit var matchAdapter: MatchAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        matchAdapter = MatchAdapter()
        matchAdapter.setDataItem(DataDummy.generateMatch())
        matchAdapter.notifyDataSetChanged()

        with(rv_match){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = matchAdapter
        }
    }
}