package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registration.*

class MainActivity : AppCompatActivity() {


    lateinit var handler:DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handler= DatabaseHelper(this)

        showHome()

        registration.setOnClickListener {
            showRegistration()
        }

        login.setOnClickListener {
            showLogIN()
        }

        save.setOnClickListener {
            handler.insertUserData(name.text.toString(), email.text.toString(),password_register.text.toString())
            showHome()
        }

        login_button.setOnClickListener {
            if(handler.userPresent(login_email.text.toString(),login_password.text.toString())) {
                Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid username or password.",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun showRegistration(){
        registration_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.GONE

    }

    private fun showLogIN(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        home_ll.visibility=View.GONE
    }

    private fun showHome(){
        registration_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_ll.visibility=View.VISIBLE
    }
}
