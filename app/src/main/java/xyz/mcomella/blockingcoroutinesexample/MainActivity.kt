package xyz.mcomella.blockingcoroutinesexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0 until 100) {
            launch(CommonPool) {
                Log.d("lol", "coroutine $i start!")
                Thread.sleep(4000)
            }
        }
    }
}
