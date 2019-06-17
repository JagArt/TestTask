package by.arro.testtask.presentation.main

import android.view.View

interface MainPresenter {

    fun onFirstAttachView(view: MainView)
    fun onAttachView(view: MainView)
    fun onDetach()
    fun onDestroy()

    fun onAddClicked()
    fun onDeleteClicked()
}