package com.chukimmuoi.androidupdate2020.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
@Entity(tableName = "themes")
data class LegoTheme(
    @PrimaryKey @field:SerializedName("id") val id: Int,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("parent_id") val parentId: Int? = null) {

    override fun toString(): String = name
}