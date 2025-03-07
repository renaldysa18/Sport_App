package com.redveloper.sportapp.core.utils

import com.redveloper.sportapp.core.domain.model.Classement
import com.redveloper.sportapp.core.domain.model.Match

object DataDummy {
//    fun generateTeam() : List<Team>{
//        val items : ArrayList<Team> = ArrayList()
//
//        for (data in 0..9){
//            val team = Team(
//                id = "$data", name = "Team $data", stadiumLocation = "Location $data",
//                teamBadge = "https://www.pngkey.com/png/detail/931-9316288_logo-bola-png-logo-sepak-bola-polos.png",
//                stadiumThumb = "https://upload.wikimedia.org/wikipedia/commons/b/b8/Etihad_Stadium.jpg",
//                nameAlt = "Team $data Team", league = "League",
//                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
//                imageFanArt = "https://i.pinimg.com/originals/6a/a6/3f/6aa63ffbb59fed8de33ed69e8cb9304e.jpg"
//            )
//            items.add(team)
//        }
//
//        return items
//    }

    fun generateMatch() : List<Match> {
        val items : ArrayList<Match> = ArrayList()
        for (data in 0..9){
            val match = Match(
                id = "$data",
                name = "Match $data",
                image = "https://i.ytimg.com/vi/0kmYSfQEIH8/maxresdefault.jpg"
            )
            items.add(match)
        }
        return items
    }

    fun generateClassement() : List<Classement> {
        val items : ArrayList<Classement> = ArrayList()
        for (data in 0..9){
            val classement = Classement(
                id = "$data", name = "Team $data",
                played = data, win = data, draw = data,
                loss = data, total = data
            )
            items.add(classement)
        }
        return items
    }
}