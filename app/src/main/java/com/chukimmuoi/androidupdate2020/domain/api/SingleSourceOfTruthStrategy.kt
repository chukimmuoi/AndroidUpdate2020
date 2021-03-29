package com.chukimmuoi.androidupdate2020.domain.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import kotlinx.coroutines.Dispatchers

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
fun <T, A> resultLiveData(databaseQuery: () -> LiveData<T>,
                          networkCall: suspend () -> Result<A>,
                          saveCallResult: suspend (A) -> Unit): LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading<T>())
        val source = databaseQuery.invoke().map { Result.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Result.Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)
        } else if (responseStatus.status == Result.Status.ERROR) {
            emit(Result.error<T>(responseStatus.message!!))
            emitSource(source)
        }
    }