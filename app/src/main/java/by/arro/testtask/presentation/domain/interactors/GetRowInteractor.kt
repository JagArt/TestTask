package by.arro.testtask.presentation.domain.interactors

import by.arro.testtask.presentation.domain.entity.Row
import io.reactivex.Flowable

interface GetRowInteractor {

    fun get(): Flowable<List<Row>>
}