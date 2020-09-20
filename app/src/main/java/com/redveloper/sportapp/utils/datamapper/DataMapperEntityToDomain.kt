package com.redveloper.sportapp.utils.datamapper

import com.redveloper.sportapp.data.source.local.entity.*
import com.redveloper.sportapp.domain.model.*

object DataMapperEntityToDomain {

    fun mapCountryEntityToDomain(input : List<CountryEntity>) : List<Country>{
       return input.map {
            Country(
                id = it.id,
                name = it.name
            )
        }
    }

    fun mapLeagueEntityToDomain(input : LeagueEntity) : League {
        return League(
            id = input.idLeague,
            name = input.name,
            logo = input.logo,
            gender = input.gender,
            selected = input.selected
        )
    }

    fun mapLisLeagueEntityToDomain(input : List<LeagueEntity>) : List<League>{
        return input.map {
            League(
                id = it.idLeague,
                name = it.name,
                logo = it.logo,
                gender = it.gender,
                selected = it.selected
            )
        }
    }

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

    fun mapDetalTeamEntityToDomain(input : TeamEntity) : Team {
        return Team(
            id = input.id,
            name = input.name,
            stadiumLocation = input.stadiumLocation,
            teamBadge = input.teamBadge,
            stadiumThumb = input.stadiumThumb,
            nameAlt = input.nameAlt,
            league = input.league,
            description = input.description,
            imageFanArt = input.imageFanart,
            isFavorite = input.isFavorite
        )
    }
}