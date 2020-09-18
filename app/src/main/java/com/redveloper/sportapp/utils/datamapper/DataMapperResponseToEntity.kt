package com.redveloper.sportapp.utils.datamapper

import com.redveloper.sportapp.data.source.local.entity.*
import com.redveloper.sportapp.data.source.remote.response.classement.ClassementResponse
import com.redveloper.sportapp.data.source.remote.response.country.CountryResponse
import com.redveloper.sportapp.data.source.remote.response.league.LeagueResponse
import com.redveloper.sportapp.data.source.remote.response.match.MatchResponse
import com.redveloper.sportapp.data.source.remote.response.team.TeamResponse

object DataMapperResponseToEntity {
    fun mapResponseToCountryEntity(input : List<CountryResponse>) : List<CountryEntity>{
        val dataList = ArrayList<CountryEntity>()
        input.map {
            val data = CountryEntity(
                name = it.name
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapResponseToLeagueEntity(input : List<LeagueResponse>) : List<LeagueEntity>{
        val dataList = ArrayList<LeagueEntity>()
        input.map {
            val data = LeagueEntity(
                id = it.idLeague,
                name = it.strLeague,
                logo = it.strLogo,
                gender = it.strGender
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapResponseToMatchEntity(input : List<MatchResponse>) : List<MatchEntity>{
        val dataList = ArrayList<MatchEntity>()
        input.map {
            val data = MatchEntity(
                id = it.idEvent,
                name = it.strEvent,
                image = it.strThumb
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapResponseToTeamEntity(input: List<TeamResponse>) : List<TeamEntity>{
        val dataList = ArrayList<TeamEntity>()
        input.map {
            val data = TeamEntity(
                id = it.idTeam,
                name = it.strTeam,
                stadiumLocation =  it.strStadiumLocation,
                teamBadge = it.strTeamBadge,
                stadiumThumb = it.strStadiumThumb,
                nameAlt = it.strAltName,
                league = it.strLeague,
                description = it.strDescription,
                imageFanart = it.strImageFanArt
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapResponseToClassementEntity(input: List<ClassementResponse>) : List<ClassementEntity>{
        val dataList = ArrayList<ClassementEntity>()
        input.map {
            val data = ClassementEntity(
                id = it.idTeam,
                name = it.name,
                played = it.played,
                win = it.win,
                draw = it.draw,
                loss = it.loss,
                total = it.total
            )
            dataList.add(data)
        }
        return dataList
    }

    fun mapResponseToDetailTeamEntity(input: TeamResponse) : TeamEntity{
        val data = TeamEntity(
            id = input.idTeam,
            name = input.strTeam,
            stadiumLocation =  input.strStadiumLocation,
            teamBadge = input.strTeamBadge,
            stadiumThumb = input.strStadiumThumb,
            nameAlt = input.strAltName,
            league = input.strLeague,
            description = input.strDescription,
            imageFanart = input.strImageFanArt
        )
        return data
    }

}