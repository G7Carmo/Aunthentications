package com.gdsdesenvolvimento.aunthentications

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gdsdesenvolvimento.aunthentications.login.AWSActivity
import com.gdsdesenvolvimento.aunthentications.login.GoogleActivity
import com.gdsdesenvolvimento.aunthentications.login.MicrosoftActivity

class OptionsProviderLoginActivity : AppCompatActivity() {
    private lateinit var btnGoogle : Button
    private lateinit var btnMicrosoft : Button
    private lateinit var btnAWS : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options_provider_login)
        initComponents()
        initListners()
    }

    private fun initComponents() {
        btnGoogle = findViewById(R.id.btnGoogle)
        btnMicrosoft = findViewById(R.id.btnMicrosoft)
        btnAWS  = findViewById(R.id.btnAws)
    }

    private fun initListners() {
        btnGoogle.setOnClickListener {
            Intent(this,GoogleActivity::class.java).apply {
                startActivity(this)
            }
        }
        btnMicrosoft.setOnClickListener {
            Intent(this,MicrosoftActivity::class.java).apply {
                startActivity(this)
            }
        }
        btnAWS.setOnClickListener {
            Intent(this,AWSActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}