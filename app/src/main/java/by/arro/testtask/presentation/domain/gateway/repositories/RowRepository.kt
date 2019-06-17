package by.arro.testtask.presentation.domain.gateway.repositories

import by.arro.testtask.presentation.domain.entity.Row
import io.reactivex.Flowable

interface RowRepository {
    fun getAll(): List<Row>

    fun getAllWithUpdate(): Flowable<List<Row>>
}