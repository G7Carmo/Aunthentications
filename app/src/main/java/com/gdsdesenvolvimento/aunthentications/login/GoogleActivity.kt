package com.gdsdesenvolvimento.aunthentications.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.gdsdesenvolvimento.aunthentications.R

class GoogleActivity : AppCompatActivity() {
    private lateinit var email : EditText
    private lateinit var senha : EditText
    private lateinit var btnCadastrar : Button
    private lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google)
        initComponents()
    }

    private fun initComponents() {
        email = findViewById(R.id.editEmail)
        senha = findViewById(R.id.editSenha)
        btnCadastrar = findViewById(R.id.cadastrar)
        btnLogin = findViewById(R.id.logar)
    }



}