package com.example.android_workmanager_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupInit()
        setupUi()
    }

    private fun setupInit() {
        setupWorkManager()

    }

    private fun setupWorkManager() {
        // create work request
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>()
                .build()

        // enqueue work
        WorkManager
            .getInstance(baseContext)
            .enqueue(uploadWorkRequest)
    }

    private fun setupUi() {
        val threadId = Thread.currentThread().id
        val threadName = Thread.currentThread().name
        Log.i(TAG, "threadId $threadId")
        Log.i(TAG, "threadName $threadName")
    }
}