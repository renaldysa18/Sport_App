package com.redveloper.sportapp.ui.classement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.redveloper.sportapp.R

class ClassementFragment : Fragment() {

    private lateinit var classementViewModel: ClassementViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        classementViewModel =
                ViewModelProviders.of(this).get(ClassementViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_classement, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        classementViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}