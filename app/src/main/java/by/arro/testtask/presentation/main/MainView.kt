package by.arro.testtask.presentation.main

import by.arro.testtask.domain.entity.Row

interface MainView {

    fun updateRows(rows: List<Row>)
}