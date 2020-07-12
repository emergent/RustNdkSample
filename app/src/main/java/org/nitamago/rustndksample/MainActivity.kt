package org.nitamago.rustndksample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        init {
            System.loadLibrary("rustndk")
        }
    }

    external fun hello(input: String?): String?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kotlin.runCatching {
            val tv = findViewById<TextView>(R.id.text_view)
            tv.text = hello("Rust")
        }
    }
}
