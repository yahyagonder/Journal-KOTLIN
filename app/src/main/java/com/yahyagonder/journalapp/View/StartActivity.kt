package com.yahyagonder.journalapp.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.yahyagonder.journalapp.R
import com.yahyagonder.journalapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser

        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.startWithoutLoginButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

    }

    fun signInClicked(view: View) {

        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if (email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this,"Enter Email or Password",Toast.LENGTH_LONG).show()

        } else {

            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener {

                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()

            }

        }

    }

    fun signUpClicked(view: View) {

        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if (email.isEmpty()|| password.isEmpty()) {

            Toast.makeText(this,"Enter Email or Password",Toast.LENGTH_LONG).show()

        } else {

            auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }

    }

    fun anonymousLoginClick(view: View) {

        auth.signInAnonymously().addOnSuccessListener {

            //SUCCESS
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }.addOnFailureListener {
            Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }


}