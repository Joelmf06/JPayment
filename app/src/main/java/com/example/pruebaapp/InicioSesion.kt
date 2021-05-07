package com.example.pruebaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebaapp.databinding.ActivityHomePageBinding
import com.example.pruebaapp.databinding.ActivityInicioSesionBinding

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