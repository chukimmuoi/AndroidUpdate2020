package com.chukimmuoi.androidupdate2020.data.offline

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chukimmuoi.androidupdate2020.domain.model.LegoTheme

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
@Dao
interface LegoThemeDao {

    @Query("SELECT * FROM themes ORDER BY id DESC")
    fun getLegoThemes(): LiveData<List<LegoTheme>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<LegoTheme>)
}