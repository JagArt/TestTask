package by.arro.testtask.domain.interactors

import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.gateway.repositories.RowRepository

class AddRowInteractorImpl(
    private val rowRepository: RowRepository
) : AddRowInteractor {

    override fun add(row: Row) {
        rowRepository.save(row)
    }
}