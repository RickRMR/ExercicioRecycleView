package com.richard.exercciorecycleview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.richard.exercciorecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ContactsAdapter.ListAdapterListener {

    private lateinit var binding: ActivityMainBinding
    private val itemList: MutableList<ContactInfo> = mutableListOf()


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        val listView = binding.Content

        createMockData()

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter =ContactsAdapter (itemList, this)
    }

    private fun createMockData(){
        itemList.add(ContactInfo("Richard" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Beatriz" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Aparecida" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Ricardo" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Simone" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Eduardo" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Carlos" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Matheus" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Ulisses" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Renato" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Marcos" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Tiago" , "(11) 1551-5451"))
        itemList.add(ContactInfo("Antonio" , "(11) 1551-5451"))
    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT). show()
    }
}