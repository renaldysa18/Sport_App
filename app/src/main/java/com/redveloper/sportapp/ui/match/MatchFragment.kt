package com.redveloper.sportapp.ui.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.domain.model.Match
import com.redveloper.sportapp.core.utils.Constanta
import com.redveloper.sportapp.core.utils.toast
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.android.synthetic.main.fragment_match.*
import org.koin.android.ext.android.inject

class MatchFragment : Fragment() {

    val viewModel: MatchViewModel by inject()
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

        with(rv_match){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = matchAdapter
        }

        getDataMatch(Constanta.ID_LEAGUE)
    }

    private fun getDataMatch(idLeague : String) {
        viewModel.match(idLeague).observe(this, Observer {data ->
            if (data != null){
                when(data){
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        showDataMatch(data.data)
                    }
                    is Resource.Error -> {
                        context?.toast(data.message.toString())
                    }
                }
            }
        })
    }

    private fun showDataMatch(data : List<Match>?){
        matchAdapter.setDataItem(data)
        matchAdapter.notifyDataSetChanged()
    }
}