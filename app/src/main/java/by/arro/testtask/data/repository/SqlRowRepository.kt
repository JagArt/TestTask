package by.arro.testtask.data.repository

import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.gateway.repositories.RowRepository
import io.reactivex.Flowable

class SqlRowRepository : RowRepository {

    override fun getAll(): List<Row> {
        return fakeData()
    }

    override fun getAllWithUpdate(): Flowable<List<Row>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun fakeData(): List<Row> {
        val values = mutableListOf<Row>()
        for (i in 0..5) {
            values.add(Row(i, "$i element"))
        }
        return values
    }
}