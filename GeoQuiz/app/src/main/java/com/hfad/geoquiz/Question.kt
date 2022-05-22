package com.hfad.geoquiz

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, var answer: Boolean)