package by.arro.testtask.data.db

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

abstract class RowRoomDatabase : RoomDatabase() {

    abstract fun getRowDao(): RowsDao

    companion object {
        @Volatile
        private var INSTANCE: RowRoomDatabase? = null

        fun getDatabase(context: Context): RowRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RowRoomDatabase::class.java,
                    "Rows_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}