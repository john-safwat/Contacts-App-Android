package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private var contacts: MutableList<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView = itemView.findViewById(R.id.user_name)
        var phoneNumber : TextView = itemView.findViewById(R.id.user_phone_number)
        var description : TextView = itemView.findViewById(R.id.user_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_card , parent , false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = contacts[position].name
        holder.phoneNumber.text = contacts[position].phoneNumber
        holder.description.text = contacts[position].description
    }

    fun addNewContact(contact: Contact){
        contacts.add(contact)
    }
}