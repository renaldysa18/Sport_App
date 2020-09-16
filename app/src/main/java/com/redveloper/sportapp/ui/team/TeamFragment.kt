package com.redveloper.sportapp.ui.team

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
import kotlinx.android.synthetic.main.fragment_team.*

class TeamFragment : Fragment() {

    private lateinit var teamViewModel: TeamViewModel
    private lateinit var teamAdapter: TeamAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamAdapter = TeamAdapter()
        teamAdapter.setItemTeam(DataDummy.generateTeam())
        teamAdapter.notifyDataSetChanged()

        with(rv_team){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = teamAdapter
        }

    }

}