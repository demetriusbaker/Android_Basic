package com.hfad.geoquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    var currentIndex = 0
    val cheatGotAnswers = hashSetOf<Int>()
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
        Question(R.string.question_europe, false),
    )
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToLeftOrRight(isRight: Boolean){
        if (isRight)
            currentIndex = (currentIndex + 1) % questionBank.size
        else {
            if (currentIndex-- <= 0)
                currentIndex = questionBank.size - 1
            currentIndex %= questionBank.size
        }
    }
}