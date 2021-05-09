package com.joelmf06.Jpayment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joelmf06.Jpayment.databinding.ActivityInicioSesionBinding

class InicioSesion : AppCompatActivity() {
    private lateinit var binding: ActivityInicioSesionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click_BtnLogin ()

    }
    fun click_BtnLogin () {
        binding.btnLogin.setOnClickListener {
            val btnIngreso: Intent = Intent (applicationContext, HomePage::class.java)
            startActivity(btnIngreso)
        }
    }
}