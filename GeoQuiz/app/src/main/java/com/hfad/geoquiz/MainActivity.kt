package com.hfad.geoquiz

// import androidx.lifecycle.ViewModelProvider
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"
private const val KEY_INDEX = "index"
private const val KEY_HINTS = "hints"
private const val REQUEST_CODE_CHEAT = 0

class MainActivity : AppCompatActivity(){
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var cheatButton: Button
    private lateinit var prevButton: ImageButton
    private lateinit var nextButton: ImageButton
    private lateinit var questionTextView: TextView
    private lateinit var hintsTextView: TextView

    private var numberHints = 3
    private var isCheated = false

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        val currentIndex = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        quizViewModel.currentIndex = currentIndex
        numberHints = savedInstanceState?.getInt(KEY_HINTS) ?: numberHints

        /*
        Class ViewModelProviders provide instance of ViewModelProvider.
        provider.get(QuizViewModel::class.java) return instance of QuizViewModel.
        When activity requests QuizViewModel, after change configuration, instance, that was
        created initially, return. When activity is end (for example, user click button "back"),
        pair ViewModel-Activity delete from memory
        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val quizViewModel = provider.get(QuizViewModel::class.java)
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")
        */

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        cheatButton = findViewById(R.id.cheat_button)
        prevButton = findViewById(R.id.prev_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)
        hintsTextView = findViewById(R.id.hints_text_view)

        printInfoAboutHints()

        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
        cheatButton.setOnClickListener { view ->
            if (numberHints > 0){
                val answerIsTrue = quizViewModel.currentQuestionAnswer
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    val intent = CheatActivity
                            .newIntent(this@MainActivity, answerIsTrue)
                    val options = ActivityOptions.makeClipRevealAnimation(view,
                            0, 0, view.width, view.height)
                    startActivityForResult(intent, REQUEST_CODE_CHEAT, options.toBundle())
                }
                startActivityForResult(intent, REQUEST_CODE_CHEAT)
            }
        }
        prevButton.setOnClickListener {
            quizViewModel.moveToLeftOrRight(false)
            updateQuestion()
        }
        nextButton.setOnClickListener {
            quizViewModel.moveToLeftOrRight(true)
            updateQuestion()
        }
        questionTextView.setOnClickListener {
            updateQuestion()
        }

        updateQuestion()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_OK) return
        if (requestCode == REQUEST_CODE_CHEAT){
            if (data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) == true){
                quizViewModel.cheatGotAnswers.add(quizViewModel.currentIndex)
                isCheated = true
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Log.i(TAG, "onSaveInstanceState")
        outState.putInt(KEY_INDEX, quizViewModel.currentIndex)
        outState.putInt(KEY_HINTS, numberHints)
    }

    private fun updateQuestion(){
        // Log.d(TAG, "Updating question text", Exception())
        val questionTextResId = quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = when {
            quizViewModel.currentIndex in quizViewModel.cheatGotAnswers -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }

        val toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()

        if (messageResId == R.string.judgment_toast && isCheated){
            numberHints--
            printInfoAboutHints()
            isCheated = false
        }
    }

    private fun printInfoAboutHints(){
        hintsTextView.text = "Count of hints: $numberHints"
    }

    /*
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
     */
}