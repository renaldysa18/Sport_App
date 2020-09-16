package com.redveloper.sportapp.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.redveloper.sportapp.R

class TeamFragment : Fragment() {

    private lateinit var teamViewModel: TeamViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        teamViewModel =
                ViewModelProviders.of(this).get(TeamViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_team, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        teamViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}