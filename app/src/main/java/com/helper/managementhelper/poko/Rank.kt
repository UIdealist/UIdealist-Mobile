package com.helper.managementhelper.poko

import com.squareup.moshi.Json

data class RankResponse (
    val error : Boolean,
    val ranks : List<Rank>
)

data class Rank (
    @Json(name = "Id") val id: Int,
    @Json(name = "Name") val name : String,
    @Json(name = "Color") val color : Int
)

data class RankCreate (
    @Json(name = "Name") val name : String,
    @Json(name = "Color") val color : Int
)