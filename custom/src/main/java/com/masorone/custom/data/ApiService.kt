package com.masorone.custom.data

import retrofit2.http.GET

interface ApiService {

    @GET("aggs/ticker/AAPL/range/1/hour/2022-01-09/2023-01-09?adjusted=true&sort=desc&limit=50000&apiKey=9G1VVkGtplvE0QopO1B9vnY2qUG6p91v")
    suspend fun loadBars(): Result
}