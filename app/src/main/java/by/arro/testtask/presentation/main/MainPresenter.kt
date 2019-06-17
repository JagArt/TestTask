package by.arro.testtask.presentation.main

interface MainPresenter {

    fun onFirstAttachView(view: MainView)
    fun onAttachView(view: MainView)
    fun onDetach()
    fun onDestroy()

    fun onAddClicked()
    fun onDeleteClicked(itemId: Int)
}