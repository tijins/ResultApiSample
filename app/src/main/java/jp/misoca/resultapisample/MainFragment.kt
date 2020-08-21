package jp.misoca.resultapisample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(R.layout.fragment_main),InputDialogFragment.InputDialogListener {

    companion object {

        fun newInstance() = MainFragment()

        private val TAG = MainActivity::class.java.simpleName
        private const val CODE_OLD_START = 1
    }

    private val activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val text = it.data?.getStringExtra(SecondActivity.EXT_TEXT)
            result_text.text = text
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        old_start.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivityForResult(intent, CODE_OLD_START)
        }

        new_start.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            activityLauncher.launch(intent)
        }

        old_fragment.setOnClickListener {
            InputDialogFragment().show(childFragmentManager, null)
        }


        //子Fragmentとデータの受け渡しを行う時は、ChildFragmentManagerに設定する
        childFragmentManager.setFragmentResultListener(NewInputDialogFragment.KEY_RESULT, viewLifecycleOwner){ _, bundle ->
            val text = bundle.getString(NewInputDialogFragment.KEY_TEXT)
            result_text.text = text
        }
        new_fragment.setOnClickListener {
            NewInputDialogFragment().show(childFragmentManager, null)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            CODE_OLD_START ->{
                if(resultCode == Activity.RESULT_OK){
                    val text = data?.getStringExtra(SecondActivity.EXT_TEXT)
                    result_text.text = text
                }
            }
        }
    }

    override fun setText(text: String) {
        result_text.text = text
    }

}
