package com.hfad.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

private const val CHEAT_DETECT = "cheat detect!"
private const val EXTRA_ANSWER_IS_TRUE =
        "хохла забыли спросить!"
const val EXTRA_ANSWER_SHOWN =
        "8-800-5-5-5-3-5-3-5, лучше позвонить, чем у кого-то занимать!"

class CheatActivity : AppCompatActivity() {
    private var answerIsTrue = false
    private var isAnswerShown = false
    private lateinit var answerTextView: TextView
    private lateinit var printAPIInformationTextView: TextView
    private lateinit var showAnswerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        isAnswerShown = savedInstanceState?.getBoolean(CHEAT_DETECT) ?: false

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        answerTextView = findViewById(R.id.answer_text_view)
        printAPIInformationTextView = findViewById(R.id.api_information_text_view)
        showAnswerButton = findViewById(R.id.show_answer_button)

        printAPIInformationTextView.text = "API Level ${Build.VERSION.SDK_INT}"

        showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)

            isAnswerShown = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(CHEAT_DETECT, isAnswerShown)
    }

    override fun onBackPressed() {
        setAnswerShowResult()
        super.onBackPressed()
    }

    private fun setAnswerShowResult(){
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent =
                Intent(packageContext, CheatActivity::class.java).apply {
                    putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
                }
    }
}