package by.arro.testtask.domain.interactors

import by.arro.testtask.domain.entity.Row

interface GetRowInteractor {

    fun get(): List<Row>
}