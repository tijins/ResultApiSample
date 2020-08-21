package jp.misoca.resultapisample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(R.layout.fragment_second) {
    companion object{
        fun newInstance() = SecondFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        set_result.setOnClickListener {
            val activity = activity as? SecondActivity ?:return@setOnClickListener
            val text = result_text.text.toString()
            activity.setResultAndFinish(text)
        }
    }
}
