package com.redveloper.sportapp.ui.league

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.redveloper.sportapp.R
import com.redveloper.sportapp.domain.model.Country
import com.redveloper.sportapp.domain.model.League
import com.redveloper.sportapp.ui.main.MainActivity
import com.redveloper.sportapp.utils.toast
import com.redveloper.sportapp.viewmodel.ViewModelFactory
import com.redveloper.sportapp.vo.Resource
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener, LeagueAdapter.LeagueAdapterImpl {

    private lateinit var viewModel: LeagueViewModel
    private lateinit var leagueAdapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        leagueAdapter = LeagueAdapter()
        leagueAdapter.setListener(this)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[LeagueViewModel::class.java]

        collectDataCountries()
        //set recycler league
        with(rv_league) {
            layoutManager = LinearLayoutManager(this@LeagueActivity)
            adapter = leagueAdapter
        }

        //countries selected item
        spinner_country_league.onItemSelectedListener = this
    }

    override fun onLeagueSelected(data: League) {
        toMain()
    }

    override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val countryName = parent?.getItemAtPosition(position).toString()
        collectDataLeague(countryName)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    private fun collectDataCountries() {
        viewModel.countries.observe(this, Observer { countries ->
            if (countries != null) {
                when (countries) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        showDropdownCountries(countries.data)
                    }
                    is Resource.Error -> {
                        countries.message?.let { toast(it) }
                    }
                }
            }
        })
    }

    private fun showDropdownCountries(countries: List<Country>?) {
        if (!countries.isNullOrEmpty()) {
            val listCountry = ArrayList<String>()
            for (data in countries) {
                listCountry.add(data.name)
            }
            spinner_country_league.adapter = setAdapterSpinner(listCountry)
        }
    }

    private fun setAdapterSpinner(datas: List<String>): SpinnerAdapter {
        val spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datas)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return spinnerAdapter
    }

    private fun collectDataLeague(countryName: String) {
        viewModel.setCountryName(countryName)
        viewModel.league.observe(this, Observer { leagues ->
            if (leagues != null) {
                when (leagues) {
                    is Resource.Success -> {
                        leagueAdapter.setDataLeague(leagues.data)
                        leagueAdapter.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        leagues.message?.let { toast(it) }
                    }
                }
            }
        })
    }

    private fun toMain(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}