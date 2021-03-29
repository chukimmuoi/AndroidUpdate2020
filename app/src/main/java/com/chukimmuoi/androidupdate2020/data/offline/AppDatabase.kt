package com.chukimmuoi.androidupdate2020.data.offline

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.chukimmuoi.androidupdate2020.domain.model.LegoTheme

/**
 * @author  : Chu Kim Muoi
 * @Skype   : chukimmuoi
 * @Mobile  : +84 373 672 505
 * @Email   : chukimmuoi@gmail.com
 * @Project : AndroidUpdate2020
 * Created by chukimmuoi on 2019-12-30.
 */
@Database(entities = [LegoTheme::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun legoThemeDao(): LegoThemeDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(
                        context
                    ).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "legocatalog-db")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                    }
                })
                .build()
        }
    }
}