package com.example.kotlin_lesson_8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)
    }

    // Активити запускается
    override fun onStart() {
        super.onStart()
        toastMeState("On_Start")
    }

    // Активность, после старта, когда он становится видимым для пользователя
    override fun onResume() {
        super.onResume()
        toastMeState("On_Resume")
    }

    // После onResume, когда возобновление активити завершился
    override fun onPostResume() {
        super.onPostResume()
        toastMeState("On_Post_Resume")
    }

    /*
    Вызывается, когда активити уходит из переднего плана
    переходит из состояния resume в start
     */
    override fun onPause() {
        super.onPause()
        toastMeState("On_Pause")
    }

    /*
    Вызывается, когда активити становится невидимым
    (когда его перекрывает другое активити)
     */
    override fun onStop() {
        super.onStop()
        toastMeState("On_Stop")
    }

    /*
    Вызывается после события onStart, если активити собирается
    вернуться в передний план и будет отображено пользователю
     */
    override fun onRestart() {
        super.onRestart()
        toastMeState("On_Restart")
    }

    /*
    Если не произошел возврат активити, то вызывается onDestroy,
    вызываемый непосредственно перед уничтожением активити
     */
    override fun onDestroy() {
        super.onDestroy()
        toastMeState("On_Destroy")
    }

    // Отображение информации о событии
    private fun toastMeState(message: String){
        Toast.makeText(this, "${lifecycle.currentState}, $message",
                Toast.LENGTH_SHORT).show()
    }
}