package by.arro.testtask.presentation.launch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.arro.testtask.presentation.main.MainActivity

class LaunchActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(MainActivity.getIntent(this))
        finish()
    }
}