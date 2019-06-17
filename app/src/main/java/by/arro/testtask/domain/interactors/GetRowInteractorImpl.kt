package by.arro.testtask.domain.interactors

import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.gateway.repositories.RowRepository

class GetRowInteractorImpl(
    private val rowRepository: RowRepository
) : GetRowInteractor {

    override fun get(): List<Row> {
        return rowRepository.getAll()
    }
}