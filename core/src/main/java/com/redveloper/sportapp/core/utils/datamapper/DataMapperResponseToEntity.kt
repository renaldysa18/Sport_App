package com.redveloper.sportapp.core.utils.datamapper

import com.redveloper.sportapp.core.data.source.local.entity.*
import com.redveloper.sportapp.core.data.source.remote.response.classement.ClassementResponse
import com.redveloper.sportapp.core.data.source.remote.response.match.MatchResponse
import com.redveloper.sportapp.core.data.source.remote.response.team.TeamResponse

object DataMapperResponseToEntity {

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

}