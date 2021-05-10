package com.joelmf06.Jpayment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.joelmf06.Jpayment.databinding.ActivityInicioSesionBinding

class InicioSesion : AppCompatActivity() {

    private lateinit var binding: ActivityInicioSesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup ()

    }
    private fun setup () {
        title = "Inicio Sesión"

        binding.btnLogin.setOnClickListener {
            if (binding.etLoginAddress.text.isNotEmpty() && binding.etLoginPassword.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.etLoginAddress.text.toString(),
                        binding.etLoginPassword.text.toString()).addOnCompleteListener {

                        if (it.isSuccessful) {
                            showLogin(it.result?.user?.email?: "")
                        }else {
                            showAlert()
                        }

                    }
            }
        }

    }
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton(text: "Aceptar", listener:null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLogin (email: String, password: String) {

        val LoginIntent: Intent = Intent (this, HomePage::class.java).apply { this
            putExtra("email", email)
            putExtra("password", password)
        }
        startActivity(LoginIntent)

    }

}