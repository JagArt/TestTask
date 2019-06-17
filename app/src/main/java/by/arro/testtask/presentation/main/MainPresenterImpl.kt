package by.arro.testtask.presentation.main

import android.view.View

class MainPresenterImpl : MainPresenter{

    private var view: MainView? = null

    override fun onFirstAttachView(view: MainView) {
        this.view = view
    }

    override fun onAttachView(view: MainView) {
        this.view = view
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


}