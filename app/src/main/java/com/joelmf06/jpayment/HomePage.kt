package com.joelmf06.jpayment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joelmf06.jpayment.databinding.ActivityHomePageBinding


class HomePage : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}