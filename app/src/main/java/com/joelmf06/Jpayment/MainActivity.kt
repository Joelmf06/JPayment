package com.joelmf06.Jpayment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joelmf06.Jpayment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        click_BtnRegistro ()
    }

    fun click_BtnRegistro () {
        binding.btnRegistro.setOnClickListener {
            /*Toast.makeText(applicationContext, "Campos obligatorios", Toast.LENGTH_SHORT).show()*/
            val btnInit: Intent = Intent (applicationContext, InicioSesion::class.java)
            startActivity(btnInit)
        }
    }

}