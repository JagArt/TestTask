package by.arro.testtask.domain.interactors

import by.arro.testtask.domain.entity.Row
import io.reactivex.Flowable

interface GetRowInteractor {

    fun get(): Flowable<List<Row>>
}