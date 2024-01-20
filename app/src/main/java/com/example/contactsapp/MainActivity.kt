package com.example.contactsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsapp.databinding.ActivityHomeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var contactsAdapter: ContactsAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsAdapter = ContactsAdapter(arrayListOf())
        binding.contactRv.adapter = contactsAdapter

        binding.saveButton.setOnClickListener { v ->
            if (nameValidate(binding.nameText.text.toString()) && phoneValidation(binding.phoneText.text.toString())) {
                contactsAdapter.addNewContact(
                    Contact(
                        binding.nameText.text.toString(),
                        binding.phoneText.text.toString(),
                        binding.descriptionText.text.toString()
                    )
                )
                contactsAdapter.notifyDataSetChanged()
            }
        }

        contactsAdapter.onItemClickListener = object:ContactsAdapter.OnItemClickListener{
            override fun onClickListener(contact: Contact) {
                val intent = Intent(this@MainActivity , ContactDetailsActivity::class.java)
                intent.putExtra("name" , contact.name)
                intent.putExtra("phoneNumber" , contact.phoneNumber)
                intent.putExtra("description" , contact.description)
                startActivity(intent)
            }
        }

    }

    private fun nameValidate(name: String): Boolean {
        return name.length >= 3
    }

    private fun phoneValidation(phoneNumber: String): Boolean {
        return phoneNumber.length >= 11
    }

}
