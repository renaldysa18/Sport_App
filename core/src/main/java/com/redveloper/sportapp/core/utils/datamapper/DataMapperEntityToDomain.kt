package com.redveloper.sportapp.core.utils.datamapper

import com.redveloper.sportapp.core.data.source.local.entity.*
import com.redveloper.sportapp.core.domain.model.*

object DataMapperEntityToDomain {


    fun mapMatchEntityToDomain(input : List<MatchEntity>) : List<Match> {
        return input.map {
            Match(
                id = it.id,
                name = it.name,
                image = it.image
            )
        }
    }

    fun mapTeamEntityToDomain(input: List<TeamEntity>) : List<Team>{
        return input.map {
            Team(
                id = it.id,
                name = it.name,
                stadiumLocation = it.stadiumLocation,
                teamBadge = it.teamBadge,
                stadiumThumb = it.stadiumThumb,
                nameAlt = it.nameAlt,
                league = it.league,
                description = it.description,
                imageFanArt = it.imageFanart,
                isFavorite = it.isFavorite
            )
        }
    }

    fun mapClassementEntityToDomain(input : List<ClassementEntity>) : List<Classement>{
        return input.map {
            Classement(
                id = it.id,
                name = it.name,
                played = it.played,
                win = it.win,
                draw = it.draw,
                loss = it.loss,
                total = it.total
            )
        }
    }
}