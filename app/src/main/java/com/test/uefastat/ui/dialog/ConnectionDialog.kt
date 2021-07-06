package com.test.uefastat.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.test.uefastat.R

class ConnectionDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            MaterialAlertDialogBuilder(it)
                .setTitle(getString(R.string.no_connection))
                .setMessage(getString(R.string.please_check))
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(getString(R.string.try_again)) { _, _ ->
                    dismiss()
                }
                .create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}
