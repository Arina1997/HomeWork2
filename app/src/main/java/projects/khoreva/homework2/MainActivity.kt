package projects.khoreva.homework2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val TAG = "MainActivity1"
const val KEY = "Letter"

class MainActivity : AppCompatActivity() {

    lateinit var resultTextView: TextView
    lateinit var printLetterAlphabetButton: Button
    lateinit var buttonClear: Button
    private var k = -1
    private lateinit var text: String
    var list = listOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
    var poem = listOf("Программист наш дорогой,",
        "Восхищаемся тобой,",
        "Умный ты такой, аж страшно,",
        "Программисту это важно!",
        "И еще ты компанейский,",
        "У тебя все по-житейски,",
        "Ты и выглядишь прекрасно,",
        "И работать с тобой классно!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,poem())
        resultTextView = findViewById(R.id.result)
        printLetterAlphabetButton = findViewById(R.id.printLetterAlphabetButton)
        buttonClear = findViewById(R.id.buttonClean)
        resultTextView.text = ""

        if (savedInstanceState != null) resultTextView.text = savedInstanceState.getString(KEY)

        listOfButtonClick()
        cleanButtonClick()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(KEY, resultTextView.text.toString())
    }

    fun poem(): String {
        k++
        return poem[k%8]
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,poem())
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,poem())
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,poem())
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,poem())
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,poem())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,poem())
    }

    private fun listOfButtonClick() {
        printLetterAlphabetButton.setOnClickListener {
            val result = resultTextView.text.toString()
            if (result.length >= 26) {
                Toast.makeText(this,
                    "Выведены все буквы алфавита!",
                    Toast.LENGTH_SHORT).show()
            } else
                resultTextView.text = result + list[result.length].toString()

        }
    }

    private fun cleanButtonClick() {
        buttonClear.setOnClickListener {
            resultTextView.text = ""
        }
    }
}