package dev.kirillzhelt.androidacademyapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.kirillzhelt.androidacademyapp.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MoviesRoomDatabase: RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: MoviesRoomDatabase? = null

        fun getInstance(context: Context): MoviesRoomDatabase {
            val tmp1 = INSTANCE

            if (tmp1 != null) {
                return tmp1
            }

            synchronized(this) {
                var tmp2 = INSTANCE

                if (tmp2 == null) {
                    tmp2 = Room.databaseBuilder(context,
                        MoviesRoomDatabase::class.java,
                        "movies").build()

                    INSTANCE = tmp2

                }

                return tmp2
            }
        }
    }

}