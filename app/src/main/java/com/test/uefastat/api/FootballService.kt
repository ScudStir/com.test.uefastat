package com.test.uefastat.api

import com.test.uefastat.model.Statistic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballService {
    @GET("v2/competitions/{id}")
    suspend fun loadStatistic(
        @Path("id") id: String
    ): Response<Statistic>
}