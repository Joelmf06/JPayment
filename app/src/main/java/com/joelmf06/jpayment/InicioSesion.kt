package com.joelmf06.jpayment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.joelmf06.jpayment.databinding.ActivityInicioSesionBinding


class InicioSesion : AppCompatActivity() {

    private lateinit var binding: ActivityInicioSesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle:Bundle? = intent.extras
        val email:String? = bundle?.getString("email")
        setup(email?: "")

    }
    private fun setup (email: String) {
        title = "Inicio Sesión"

        binding.btnLogin.setOnClickListener {
            if (binding.etLoginAddress.text.isNotEmpty() && binding.etLoginPassword.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(binding.etLoginAddress.text.toString(),
                        binding.etLoginPassword.text.toString()).addOnCompleteListener {

                        if (it.isSuccessful) {
                            showLogin()
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
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLogin () {

        val loginIntent = Intent (this, HomePage::class.java)
        startActivity(loginIntent)

    }

}