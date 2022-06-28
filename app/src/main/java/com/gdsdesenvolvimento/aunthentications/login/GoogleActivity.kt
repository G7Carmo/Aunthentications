package com.gdsdesenvolvimento.aunthentications.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gdsdesenvolvimento.aunthentications.MainActivity
import com.gdsdesenvolvimento.aunthentications.R
import com.gdsdesenvolvimento.aunthentications.login.provedores.ProvedoresFirebaseActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class GoogleActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var senha: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var btnLogin: Button
    private lateinit var btnAnonimos: Button
    private lateinit var btnProvedores: Button

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        email = findViewById(R.id.editEmail)
        senha = findViewById(R.id.editSenha)
        btnCadastrar = findViewById(R.id.cadastrar)
        btnLogin = findViewById(R.id.logar)
        btnAnonimos = findViewById(R.id.btnAnonimo);
        btnProvedores = findViewById(R.id.btnProvedores)
        auth = Firebase.auth
    }


    private fun initListeners() {
        btnCadastrar.setOnClickListener {
            val textEmail = email.text.toString()
            val textSenha = senha.text.toString()
            if (textEmail.isNotEmpty() && textSenha.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(textEmail, textSenha)
                    .addOnSuccessListener {
                        Intent(this,MainActivity::class.java).apply {
                            this.putExtra("Metodo","Cadastrado com email e senha")
                            startActivity(this)
                        }
                    }
                    .addOnFailureListener {
                        val msg = try {
                            throw it
                        }catch (e :FirebaseException){
                            e.message
                        }
                        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
                    }
            }
        }
        btnLogin.setOnClickListener {
            val textEmail = email.text.toString()
            val textSenha = senha.text.toString()
            if (textEmail.isNotEmpty() && textSenha.isNotEmpty()) {
                auth.signInWithEmailAndPassword(textEmail, textSenha)
                    .addOnSuccessListener {
                        Intent(this,MainActivity::class.java).apply {
                            this.putExtra("Metodo","Login feito  com email e senha")
                            startActivity(this)
                        }
                    }
                    .addOnFailureListener {
                        val msg = try {
                            throw it
                        }catch (e :FirebaseException){
                            e.message
                        }
                        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
                    }
            }
        }
        btnAnonimos.setOnClickListener {
            auth.signInAnonymously()
                .addOnSuccessListener {
                    Intent(this,MainActivity::class.java).apply {
                        this.putExtra("Metodo","Logado de forma anonima")
                        startActivity(this)
                    }
                }
                .addOnFailureListener {
                    val msg = try {
                        throw it
                    }catch (e :FirebaseException){
                        e.message
                    }
                    Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
                }
        }
        btnProvedores.setOnClickListener {
            Intent(this, ProvedoresFirebaseActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}
