package com.example.android_workmanager_learning

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(
    appContext: Context,
    workerParams: WorkerParameters,
) : Worker(appContext, workerParams) {

    companion object {
        private const val TAG = "UploadWorker"
    }

    override fun doWork(): Result {
        uploadImages()
        return Result.success()
    }

    fun uploadImages() {
        val threadId = Thread.currentThread().id
        val threadName = Thread.currentThread().name
        Log.i(TAG, "threadId $threadId")
        Log.i(TAG, "threadName $threadName")
        Log.i(TAG, "uploading images")
    }
}