package com.redveloper.sportapp.utils.datamapper

import com.redveloper.sportapp.data.source.local.entity.LeagueEntity
import com.redveloper.sportapp.domain.model.League

object DataMapperDomainToEntity {

    fun mapLeaguDomainToEntity(input : League) : LeagueEntity {
        return LeagueEntity(
            input.id,
            input.name,
            input.logo,
            input.gender
        )
    }
}