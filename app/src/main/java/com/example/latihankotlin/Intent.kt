package com.example.latihankotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.*

class Intent : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        IntentView().setContentView(this)

        var btn : Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            handleAlert()
        }
    }

    //membuat class yang akan mendesign layout
    class IntentView : AnkoComponent<Intent> {
        override fun createView(ui: AnkoContext<Intent>) = with(ui){
            verticalLayout{
                lparams{
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = Gravity.CENTER
                    backgroundColor = R.color.abuabu
                }
                verticalLayout{
                    lparams(width = matchParent, height = wrapContent){
                        backgroundColor = Color.WHITE
                        margin = 15
                        padding = 20

                    }
                    button("INFO"){
                        id = R.id.btn
                    }.lparams(width = wrapContent, height = wrapContent){
                        margin = 15
                        gravity = Gravity.CENTER
                    }
                }
            }
        }
    }

    private fun handleAlert(){
            alert(title = "Alert", message = "Sebuah Alert"){
                positiveButton(buttonText = "OK"){
                    onBackPressed()
                    finish()
                }
                isCancelable = false
            }.show()
    }
}