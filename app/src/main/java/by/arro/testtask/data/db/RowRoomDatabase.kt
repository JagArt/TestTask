package by.arro.testtask.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import by.arro.testtask.data.entity.RowDataModel

@Database(entities = [RowDataModel::class], version = 1)
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

        fun onClose() {
            if (INSTANCE?.isOpen != null) INSTANCE?.close();
            INSTANCE = null
        }
    }
}