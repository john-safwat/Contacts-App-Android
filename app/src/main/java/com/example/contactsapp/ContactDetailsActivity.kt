package com.example.contactsapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsapp.databinding.ActivityContactDetilsBinding

class ContactDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetilsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetilsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.userNameDetails.text = intent.getStringExtra("name")
        binding.userPhoneNumberDetails.text = intent.getStringExtra("phoneNumber")
        binding.userDescriptionDetails.text = intent.getStringExtra("description")
        binding.arrowBack.setOnClickListener {
            finish()
        }
    }
}