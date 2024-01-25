package com.example.nychighschools.data

import com.example.nychighschools.data.model.HighSchool
import retrofit2.http.GET

interface Service {

    @GET("s3k6-pzi2.json")
    suspend fun getHighSchools(): List<HighSchool>
}