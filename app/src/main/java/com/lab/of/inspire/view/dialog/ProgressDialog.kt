package com.lab.of.inspire.view.dialog

import android.app.Dialog
import android.content.Context
import android.view.Window
import com.lab.of.inspire.R

class ProgressDialog(var context: Context) {

    private var dialog: Dialog? = null

    private fun showProgress() {
        dialog = Dialog(context).apply {
            window?.setBackgroundDrawableResource(R.color.transparent)
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.view_progress_dialog)
            setCancelable(false)
            show()
        }
    }

    private fun hideProgress() {
        dialog?.dismiss()
    }

    fun changeProgressState(show: Boolean) {
        if (show) {
            showProgress()
        } else {
            hideProgress()
        }
    }

}