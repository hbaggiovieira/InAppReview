package com.example.myapplication.ui.main

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.android.play.core.review.testing.FakeReviewManager

class InAppReviewViewModel(
    private val manager: FakeReviewManager
) : ViewModel(){


    fun requestInAppReview () {

        val request = manager.requestReviewFlow()
        request.addOnCompleteListener {request ->
            if (request.isSuccessful) {
                val reviewInfo = request.result
                val flow = manager.launchReviewFlow(Activity() ,reviewInfo)
                flow.addOnCompleteListener { _ ->
                    Toast.makeText(Activity(), "Sucesso requestInAppReview", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(Activity(), "Sem sucesso requestInAppReview", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
