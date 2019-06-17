package by.arro.testtask.domain.interactors

import by.arro.testtask.domain.gateway.repositories.RowRepository

class DeleteRowInteractorImpl(
    private val rowRepository: RowRepository
) : DeleteRowInteractor {

    override fun delete(itemId: Int) {
        rowRepository.deleteById(itemId)
    }
}