package com.chukimmuoi.androidupdate2020.data.online

import com.chukimmuoi.androidupdate2020.domain.api.ResultsResponse
import com.chukimmuoi.androidupdate2020.domain.model.LegoTheme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
interface LegoService {

    companion object {
        const val ENDPOINT = "https://rebrickable.com/api/v3/"
    }

    @GET("lego/themes/")
    suspend fun getThemes(@Query("page") page: Int? = null,
                          @Query("page_size") pageSize: Int? = null,
                          @Query("ordering") order: String? = null): Response<ResultsResponse<LegoTheme>>
}