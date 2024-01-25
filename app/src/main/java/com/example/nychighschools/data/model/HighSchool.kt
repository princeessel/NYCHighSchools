package com.example.nychighschools.data.model

import com.google.gson.annotations.SerializedName

data class HighSchool (
    @SerializedName("dbn") val dbn: String,
    @SerializedName("school_name") val schoolName: String,
    @SerializedName("overview_paragraph") val overviewParagraph: String,
)