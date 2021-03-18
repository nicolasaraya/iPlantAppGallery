package com.iPlantApp.iplant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class Login : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        if(FirebaseAuth.getInstance().currentUser != null ){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        anonymus.setOnClickListener{
            firebaseAuth.signInAnonymously().addOnCompleteListener (this){
                if(it.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        }
        firebaseAuth = FirebaseAuth.getInstance()
    }















}