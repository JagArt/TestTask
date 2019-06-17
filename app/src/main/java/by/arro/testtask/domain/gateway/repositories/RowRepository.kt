package by.arro.testtask.domain.gateway.repositories

import by.arro.testtask.domain.entity.Row
import io.reactivex.Flowable

interface RowRepository {

    fun getAll(): List<Row>

    fun getAllWithUpdate(): Flowable<List<Row>>
}