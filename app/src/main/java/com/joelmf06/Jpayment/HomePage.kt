package com.joelmf06.Jpayment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joelmf06.Jpayment.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}