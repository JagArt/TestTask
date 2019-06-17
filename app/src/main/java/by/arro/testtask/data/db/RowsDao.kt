package by.arro.testtask.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import by.arro.testtask.data.entity.RowDataModel
import io.reactivex.Flowable

@Dao
interface RowsDao {

    @Query("SELECT * FROM rows_table")
    fun getAll(): List<RowDataModel>

    @Query("SELECT * FROM rows_table")
    fun getAllWithUpdates(): Flowable<List<RowDataModel>>
}