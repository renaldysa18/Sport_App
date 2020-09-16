package com.redveloper.sportapp.ui.classement

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
import kotlinx.android.synthetic.main.fragment_classement.*

class ClassementFragment : Fragment() {

    private lateinit var classementViewModel: ClassementViewModel
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
        classementAdapter.setDataItem(DataDummy.generateClassement())
        classementAdapter.notifyDataSetChanged()

        with(rv_classement){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = classementAdapter
        }
    }
}