package com.chukimmuoi.androidupdate2020.ui.legotheme.repository

import com.chukimmuoi.androidupdate2020.data.offline.LegoThemeDao
import com.chukimmuoi.androidupdate2020.domain.api.resultLiveData
import com.chukimmuoi.androidupdate2020.ui.legotheme.repository.datasource.LegoThemeRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
@Singleton
class LegoThemeRepository @Inject constructor(private val dao: LegoThemeDao,
                                              private val remoteSource: LegoThemeRemoteDataSource
) {

    val themes = resultLiveData(
        databaseQuery = { dao.getLegoThemes() },
        networkCall = { remoteSource.fetchData() },
        saveCallResult = { dao.insertAll(it.results) })

}
