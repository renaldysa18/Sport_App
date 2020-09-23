package com.redveloper.sportapp.ui.classement

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.core.utils.Constanta
import com.redveloper.sportapp.core.utils.toast
import com.redveloper.sportapp.core.vo.Resource
import kotlinx.android.synthetic.main.fragment_classement.*
import org.koin.android.viewmodel.ext.android.viewModel

class ClassementFragment : Fragment() {

    val classementViewModel: ClassementViewModel by viewModel()
    private lateinit var classementAdapter: ClassementAdapter
    private lateinit var progressDialog : ProgressDialog

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
        progressDialog = ProgressDialog(requireActivity())

        with(rv_classement){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = classementAdapter
        }

        getDataClassement(Constanta.ID_LEAGUE)
    }

    private fun getDataClassement(idLeague: String) {
        classementViewModel.classement(idLeague).observe(viewLifecycleOwner, Observer { data ->
            if (data != null){
                when(data){
                    is Resource.Loading -> {
                        progressDialog.setMessage(resources.getString(R.string.loading))
                        progressDialog.show()
                    }
                    is Resource.Success -> {
                        classementAdapter.setDataItem(data.data)
                        classementAdapter.notifyDataSetChanged()
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
}