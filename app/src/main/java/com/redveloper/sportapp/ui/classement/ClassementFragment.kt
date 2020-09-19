package com.redveloper.sportapp.ui.classement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.utils.toast
import com.redveloper.sportapp.viewmodel.ViewModelFactory
import com.redveloper.sportapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_classement.*

class ClassementFragment : Fragment() {

    private lateinit var viewModel: ClassementViewModel
    private lateinit var classementAdapter: ClassementAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        classementAdapter = ClassementAdapter()

        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(requireActivity(), factory)[ClassementViewModel::class.java]

        with(rv_classement){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = classementAdapter
        }

        viewModel.league.observe(this, Observer { data ->
            if (data != null){
                val idLeague = data.id
                getDataClassement(idLeague)
            }
        })
    }

    private fun getDataClassement(idLeague: String) {
        viewModel.classement(idLeague).observe(this, Observer { data ->
            if (data != null){
                when(data){
                    is Resource.Loading -> {}
                    is Resource.Succes -> {
                        classementAdapter.setDataItem(data.data)
                        classementAdapter.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        context?.toast(data.message.toString())
                    }
                }
            }
        })
    }
}