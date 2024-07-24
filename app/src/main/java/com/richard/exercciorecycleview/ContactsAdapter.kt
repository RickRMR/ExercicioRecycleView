package com.richard.exercciorecycleview

import android.app.LauncherActivity.ListItem
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.richard.exercciorecycleview.databinding.ContactslayoutBinding

class ContactsAdapter(
    val listItems: MutableList<ContactInfo>,
    val listener: ListAdapterListener):
    RecyclerView.Adapter<ContactsAdapter.ListContactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListContactsViewHolder {
        return ListContactsViewHolder (ContactslayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
    override fun onBindViewHolder(holder: ListContactsViewHolder, position: Int) {
        val item = listItems[position]
        holder.nickname.text = item.name
        holder.number.text = item.phone.toString()

        holder.root.setOnClickListener {
            listener.onItemClicked(item.toString())
        }
    }

    class ListContactsViewHolder(binding: ContactslayoutBinding): RecyclerView.ViewHolder(binding.root){
        var root = binding.root
        var nickname = binding.nickname
        var number = binding.number
    }

    interface ListAdapterListener{
        fun onItemClicked(content: String);
    }
}
