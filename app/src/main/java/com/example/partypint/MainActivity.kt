package com.example.partypint

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var textBBBSleep: TextView
    private val initialText = "amai kzen zat \uD83C\uDF7B\uD83C\uDF7B"
    private val zzzText = "fuck"
    private val delayMillis: Long = 500 // Adjust the delay as needed
    private val handler = Handler(Looper.getMainLooper())
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)

        textBBBSleep = findViewById(R.id.textViewBBBSleep)
        startWriting(initialText)
    }

    private fun startWriting(textToWrite: String) {
        currentIndex = 0
        writeText(textToWrite)
    }

    private fun writeText(textToWrite: String) {
        handler.postDelayed({
            if (currentIndex < textToWrite.length) {
                val newText = textToWrite.substring(0, currentIndex + 1)
                textBBBSleep.text = newText
                currentIndex++
                writeText(textToWrite)
            } else {
                // Text has been fully written
                if (textToWrite == initialText) {
                    // Switch to writing "zzz" after a brief delay
                    handler.postDelayed({ startWriting(zzzText) }, delayMillis)
                } else {
                    // Start over with the initial text
                    startWriting(initialText)
                }
            }
        }, delayMillis / 5)
    }
}
