package com.chukimmuoi.androidupdate2020.ui.legotheme.repository.datasource

import com.chukimmuoi.androidupdate2020.data.online.BaseDataSource
import com.chukimmuoi.androidupdate2020.data.online.LegoService
import javax.inject.Inject

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
class LegoThemeRemoteDataSource @Inject constructor(private val service: LegoService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getThemes(1, 1000, "-id") }

}