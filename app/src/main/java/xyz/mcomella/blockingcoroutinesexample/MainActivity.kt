package xyz.mcomella.blockingcoroutinesexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLooper = Looper.getMainLooper()
        for (i in 0 until 100) {
            launch(Unconfined) {
                val isMainThread = Looper.myLooper() == mainLooper
                Log.d("lol", "coroutine $i start! isMainTheard: $isMainThread")
                Thread.sleep(4000)
            }
        }
    }
}
