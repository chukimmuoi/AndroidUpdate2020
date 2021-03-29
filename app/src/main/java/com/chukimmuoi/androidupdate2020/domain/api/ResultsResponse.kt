package com.chukimmuoi.androidupdate2020.domain.api

import com.google.gson.annotations.SerializedName

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
data class ResultsResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: String? = null,
    @SerializedName("results")
    val results: List<T>
)