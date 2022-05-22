package info.fandroid.databindingsample

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("app:hideIfZero")
    fun hideIfZero(view: View, number: Int){
        view.visibility = if (number == 0) View.GONE else View.VISIBLE
    }

@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
    fun setProgress(progressBar: ProgressBar, likes: Int, max: Int){
        progressBar.progress = (likes * max / 5).coerceAtMost(max)
    }