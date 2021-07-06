package com.test.uefastat.model

import Seasons

data class Statistic(
    var name: String? = null,
    var areaName: String? = null,
    var seasons: List<Seasons>?=null,
)
