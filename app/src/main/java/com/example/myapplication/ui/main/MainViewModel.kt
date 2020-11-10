package com.example.myapplication.ui.main

import android.app.Activity
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.google.android.play.core.review.testing.FakeReviewManager

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val manager = FakeReviewManager(application)


    fun requestInAppReview () {
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener {request ->
            if (request.isSuccessful) {
                val reviewInfo = request.result
                val flow = manager.launchReviewFlow(Activity() ,reviewInfo)
                flow.addOnCompleteListener { _ ->
                }
            } else {
                Toast.makeText(Activity(), "Sem sucesso requestInAppReview", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
}