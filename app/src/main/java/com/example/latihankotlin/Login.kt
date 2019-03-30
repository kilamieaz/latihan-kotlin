package com.example.latihankotlin

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*

class Login : AppCompatActivity(), AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogView().setContentView(this)
        var btn : Button = findViewById(R.id.btn)
        var em : EditText = findViewById(R.id.et_email)
        var pw : EditText = findViewById(R.id.et_password)
        var tv_ca : TextView = findViewById(R.id.tv_ca)
        btn.setOnClickListener {
            val email = em.text.toString().trim()
            val password = pw.text.toString().trim()
            handleLogin(email, password)
        }
        tv_ca.setOnClickListener {
            toast("Pindah Ke halaman Register")
            startActivity(intentFor<Intent>())
        }
    }

    class LogView : AnkoComponent<Login> {
        override fun createView(ui: AnkoContext<Login>) = with(ui) {
            verticalLayout{
                lparams(width = matchParent, height = matchParent){
                    background = ColorDrawable(Color.parseColor("#369D98"))
                }
                imageView {
                    setImageResource(R.drawable.firebase)
                }.lparams(width = matchParent, height = 300){
                    topMargin = 50
                    bottomMargin = 30
                }
                editText{
                    id = R.id.et_email
                    hint = "Email"
                    inputType = InputType.TYPE_CLASS_TEXT
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = 70
                    rightMargin = 30
                    leftMargin = 30
                }
                editText{
                    id = R.id.et_password
                    hint = "Password"
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = 70
                    rightMargin = 30
                    leftMargin = 30
                }
                button("LOGIN"){
                    id = R.id.btn
                    background = ColorDrawable(Color.YELLOW)
                }.lparams(width = matchParent, height = 170){
                    topMargin = 100
                    rightMargin = 30
                    leftMargin = 30
                    gravity = Gravity.CENTER
                }
                textView{
                    hint = "Forgot your password?"
                    hintTextColor = Color.YELLOW
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = 100
                }
                textView{
                    id = R.id.tv_ca
                    hint = "Intent!"
                    hintTextColor = Color.WHITE
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(width = matchParent, height = wrapContent){
                    topMargin = 500
                }
            }
        }
    }

    //membuat function atau method untuk handleLogin
    private fun handleLogin(username : String, password : String) {
        info { "data username : $username, data password : $password" }  //Log.i jika ditulis di java
        if (username.equals("test") && password.equals("test123")){
            toast("Welcome Aboard $username")
        }else{
            alert(title = "Warning", message = "Password atau Username salah") {
                positiveButton(buttonText = "OK") {

                }
                isCancelable = false
            }.show()
        }
    }
}