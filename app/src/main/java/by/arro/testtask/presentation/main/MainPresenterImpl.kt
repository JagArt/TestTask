package by.arro.testtask.presentation.main

import by.arro.testtask.presentation.domain.entity.Row

class MainPresenterImpl : MainPresenter {

    private var view: MainView? = null
    private var items: List<Row> = listOf()

    override fun onFirstAttachView(view: MainView) {
        this.view = view
        view.renderAll()
    }

    override fun onAttachView(view: MainView) {
        this.view = view
        view.renderAll()

    }

    override fun onDetach() {
        view = null
    }

    override fun onDestroy() {
        view = null
    }

    override fun onAddClicked() {
        println("add_click")
    }

    override fun onDeleteClicked() {
        println("delete_click")
    }

    private fun MainView.renderAll() {
        updateRows(items)
    }
}