package by.arro.testtask.domain.interactors

import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.gateway.repositories.RowRepository
import io.reactivex.Flowable

class GetRowInteractorImpl(
    private val rowRepository: RowRepository
) : GetRowInteractor {

    override fun get(): Flowable<List<Row>> {
        return rowRepository.getAllWithUpdate()
    }
}