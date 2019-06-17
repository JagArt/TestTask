package by.arro.testtask.presentation.main

import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.interactors.AddRowInteractor
import by.arro.testtask.domain.interactors.GetRowInteractor
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(
    private val getRowInteractor: GetRowInteractor,
    private val addRowInteractor: AddRowInteractor
) : MainPresenter {

    private var view: MainView? = null
    private var items: List<Row> = listOf()

    private var compositeDisposable = CompositeDisposable()

    override fun onFirstAttachView(view: MainView) {
        this.view = view
        subscrybeToRowsLoad()
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

        compositeDisposable.clear()
    }

    override fun onAddClicked() {
        val disposable = Completable.fromCallable { addRowInteractor.add(Row(0, "123")) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        compositeDisposable.add(disposable)
    }

    override fun onDeleteClicked() {
        println("delete_click")
    }

    private fun MainView.renderAll() {
        updateRows(items)
    }

    private fun subscrybeToRowsLoad() {
        val disposable = getRowInteractor.get()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe() { items ->
                this.items = items
                view?.updateRows(items)
            }
        compositeDisposable.add(disposable)
    }
}