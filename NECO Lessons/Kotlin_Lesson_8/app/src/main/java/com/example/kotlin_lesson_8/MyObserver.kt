package com.example.kotlin_lesson_8

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyObserver : LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun lifeFunction(source: LifecycleOwner, event: Lifecycle.Event){
        Log.d("TAG", event.toString())
    }
}