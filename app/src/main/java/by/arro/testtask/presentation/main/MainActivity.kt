package by.arro.testtask.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import by.arro.testtask.R
import by.arro.testtask.data.repository.SqlRowRepository
import by.arro.testtask.domain.entity.Row
import by.arro.testtask.domain.interactors.GetRowInteractorImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupPresenter()
    }

    override fun updateRows(rows: List<Row>) {
        adapter.update(rows)
    }

    private fun initViews() {
        fab.setOnClickListener { presenter.onAddClicked() }
        initRecyclerViews()
    }

    private fun initRecyclerViews() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RowsAdatpter(this)
    }


    private fun setupPresenter() {
        presenter = (lastNonConfigurationInstance as? MainPresenter)?.apply {
            onAttachView(this@MainActivity)
        } ?: createPresenter().apply {
            onFirstAttachView(this@MainActivity)
        }
    }

    private fun createPresenter(): MainPresenter {
        return MainPresenterImpl(
            GetRowInteractorImpl(SqlRowRepository())
        )
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    override fun onDestroy() {
        if (isChangingConfigurations) {
            presenter.onDetach()
        } else {
            presenter.onDestroy()
        }
        super.onDestroy()
    }

    private val adapter: RowsAdatpter
        get() = recyclerView.adapter as RowsAdatpter

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
