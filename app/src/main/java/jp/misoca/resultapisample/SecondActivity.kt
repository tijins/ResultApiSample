package jp.misoca.resultapisample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_main.*

class SecondActivity : AppCompatActivity() {

    companion object{
        const val EXT_TEXT = "ext_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .commitNow()
        }
    }

    fun setResultAndFinish(text:String){
        val intent = Intent().apply {
            putExtra(EXT_TEXT, text)
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}
