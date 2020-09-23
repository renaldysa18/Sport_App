package com.redveloper.sportapp.ui.match

import android.app.ProgressDialog
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
import org.koin.android.viewmodel.ext.android.viewModel

class MatchFragment : Fragment() {

    val mathViewModel: MatchViewModel by viewModel()
    private lateinit var matchAdapter: MatchAdapter
    private lateinit var progressDialog : ProgressDialog

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
        progressDialog = ProgressDialog(requireActivity())

        with(rv_match){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = matchAdapter
        }

        getDataMatch(Constanta.ID_LEAGUE)
    }

    private fun getDataMatch(idLeague : String) {
        mathViewModel.match(idLeague).observe(viewLifecycleOwner, Observer {data ->
            if (data != null){
                when(data){
                    is Resource.Loading -> {
                        progressDialog.setMessage(resources.getString(R.string.loading))
                        progressDialog.show()
                    }
                    is Resource.Success -> {
                        showDataMatch(data.data)
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

    private fun showDataMatch(data : List<Match>?){
        matchAdapter.setDataItem(data)
        matchAdapter.notifyDataSetChanged()
    }
}