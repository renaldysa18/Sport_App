package com.redveloper.sportapp.core.utils.datamapper

import com.redveloper.sportapp.core.data.source.local.entity.TeamEntity
import com.redveloper.sportapp.core.domain.model.Team

object DataMapperDomainToEntity {

    fun mapTeamDomainToEntity(input: Team): TeamEntity {
        return TeamEntity(
            id = input.id,
            name = input.name,
            stadiumLocation = input.stadiumLocation,
            teamBadge = input.teamBadge,
            stadiumThumb = input.stadiumThumb,
            nameAlt = input.nameAlt,
            league = input.league,
            description = input.description,
            imageFanart = input.imageFanArt
        )
    }
}