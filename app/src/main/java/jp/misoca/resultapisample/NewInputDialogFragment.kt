package jp.misoca.resultapisample

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult

class NewInputDialogFragment:DialogFragment() {
    companion object{
        const val KEY_RESULT = "NewInputDialogFragment.result"
        const val KEY_TEXT = "text"
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setView(R.layout.fragment_input_dialog)
            .setPositiveButton(R.string.ok){ _ , _ ->
                val resultText = dialog?.findViewById<EditText>(R.id.result_text) ?: return@setPositiveButton
                val text = resultText.text.toString()
                setFragmentResult(KEY_RESULT, bundleOf(KEY_TEXT to text))
                dismiss()
            }
            .setNegativeButton(R.string.cancel, null)
            .create()
    }
}
