package com.example.aula01

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aula01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingLog: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bindingLog = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingLog.root)

        ViewCompat.setOnApplyWindowInsetsListener(bindingLog.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        bindingLog.btnSoma.setOnClickListener{
            // Adiciona o valor
            val num1String = bindingLog.txtNum1.text.toString()
            val num2String = bindingLog.txtNum2.text.toString()

            val num1 = num1String.toDoubleOrNull() ?: 0.0
            val num2 = num2String.toDoubleOrNull() ?: 0.0

            val res = bindingLog.lblRes

            res.text = (num1 + num2).toString()

            bindingLog.txtNum1.text.clear()
            bindingLog.txtNum2.text.clear()

            bindingLog.txtNum1.requestFocus()
        }


    }
}
