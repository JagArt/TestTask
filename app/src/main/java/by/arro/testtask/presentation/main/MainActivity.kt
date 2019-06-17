package by.arro.testtask.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.arro.testtask.R
import by.arro.testtask.presentation.domain.entity.Row

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
    }

    override fun updateRows(rows: List<Row>) {

    }


    private fun setupPresenter() {
        presenter = (lastNonConfigurationInstance as? MainPresenter)?.apply {
            onAttachView(this@MainActivity)
        } ?:MainPresenterImpl().apply {
            onFirstAttachView(this@MainActivity)
        }
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
