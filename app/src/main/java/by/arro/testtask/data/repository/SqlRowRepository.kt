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

    override fun save(row: Row) {
        rowsDao.insert(coreToRowDataModel(row))
    }

    override fun deleteById(itemId: Int) {
        rowsDao.deleteById(itemId)
    }

    private fun coreToRowDataModel(row: Row) = RowDataModel(row.id, row.rowValue)


    private fun RowDataModel.rowDataModelToCore() = Row(id, rowValue)
}