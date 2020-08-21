package jp.misoca.resultapisample

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class InputDialogFragment:DialogFragment() {
    interface InputDialogListener{
        fun setText(text:String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.fragment_input_dialog)
            .setPositiveButton(R.string.ok){ _ , _ ->
                val parent = parentFragment as? InputDialogListener ?: return@setPositiveButton
                val resultText = dialog?.findViewById<EditText>(R.id.result_text) ?: return@setPositiveButton
                val text = resultText.text.toString()
                parent.setText(text)
                dismiss()
            }
            .setNegativeButton(R.string.cancel, null)
            .create()
    }
}
