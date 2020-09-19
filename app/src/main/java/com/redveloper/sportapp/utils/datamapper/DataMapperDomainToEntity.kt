package com.redveloper.sportapp.utils.datamapper

import com.redveloper.sportapp.data.source.local.entity.LeagueEntity
import com.redveloper.sportapp.data.source.local.entity.TeamEntity
import com.redveloper.sportapp.domain.model.League
import com.redveloper.sportapp.domain.model.Team

object DataMapperDomainToEntity {

    fun mapLeaguDomainToEntity(input : League) : LeagueEntity {
        return LeagueEntity(
            input.id,
            input.name,
            input.logo,
            input.gender
        )
    }
    
    fun mapTeamDomainToEntity(input : Team) : TeamEntity{
        return TeamEntity(
            id = input.id,
            name = input.name,
            stadiumLocation =  input.stadiumLocation,
            teamBadge = input.teamBadge,
            stadiumThumb = input.stadiumThumb,
            nameAlt = input.nameAlt,
            league = input.league,
            description = input.description,
            imageFanart = input.imageFanArt
        )
    }
}