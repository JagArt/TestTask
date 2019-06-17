package by.arro.testtask.data.repository

import by.arro.testtask.data.db.RowsDao
import by.arro.testtask.data.entity.RowDataModel
import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.gateway.repositories.RowRepository
import io.reactivex.Flowable

class SqlRowRepository(private val rowsDao: RowsDao) : RowRepository {

    override fun getAll(): List<Row> {
        return rowsDao.getAll().map {
            it.rowDataModelToCore()
        }
    }

    override fun getAllWithUpdate(): Flowable<List<Row>> {
        return rowsDao.getAllWithUpdates().map {
            it.map { it.rowDataModelToCore() }
        }
    }

    private fun RowDataModel.rowDataModelToCore() = Row(id, rowValue)
}