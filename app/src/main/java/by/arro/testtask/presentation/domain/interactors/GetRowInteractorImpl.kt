package by.arro.testtask.presentation.domain.interactors

import by.arro.testtask.presentation.domain.entity.Row
import by.arro.testtask.presentation.domain.gateway.repositories.RowRepository
import io.reactivex.Flowable

class GetRowInteractorImpl(
    private val rowRepository: RowRepository
) : GetRowInteractor {

    override fun get(): Flowable<List<Row>> {
        return rowRepository.getAllWithUpdate()
    }
}