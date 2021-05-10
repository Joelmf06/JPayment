package com.joelmf06.Jpayment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ActionCodeEmailInfo
import com.google.firebase.auth.FirebaseAuth
import com.joelmf06.Jpayment.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Setup
        setup ()

    }
     private fun setup () {
         title = "Autenticacíón"

         binding.btnRegistro.setOnClickListener {
             if (binding.etEmailAddress.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {

                 FirebaseAuth.getInstance()
                     .createUserWithEmailAndPassword(binding.etEmailAddress.text.toString(),
                     binding.etPassword.text.toString()).addOnCompleteListener {

                         if (it.isSuccessful) {
                             showLogin(it.result?.user?.email ?: "")
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
        builder.setPositiveButton( text: "Aceptar", listener:null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLogin (email: String, password: String) {

            val LoginIntent: Intent = Intent (this, InicioSesion::class.java).apply { this
            putExtra("email", email)
            putExtra("password", password)
            }
            startActivity(LoginIntent)

    }


}