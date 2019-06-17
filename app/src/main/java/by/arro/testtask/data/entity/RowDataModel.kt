package by.arro.testtask.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "rows_table")
data class RowDataModel(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var rowValue: String
)