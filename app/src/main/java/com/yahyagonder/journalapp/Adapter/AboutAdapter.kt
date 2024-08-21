package com.yahyagonder.journalapp.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.yahyagonder.journalapp.Model.AboutItem
import com.yahyagonder.journalapp.Model.ActionType
import com.yahyagonder.journalapp.View.StartActivity
import com.yahyagonder.journalapp.databinding.AboutItemBinding

class AboutAdapter(private val aboutItemList: List<AboutItem>): RecyclerView.Adapter<AboutAdapter.AboutViewHolder>() {

    private val auth = FirebaseAuth.getInstance()

    class AboutViewHolder(val binding: AboutItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        val binding = AboutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AboutViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return aboutItemList.size
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        val item = aboutItemList[position]
        holder.binding.imageView.setImageResource(item.itemImage)
        holder.binding.title.text = item.itemTitle
        holder.binding.description.text = item.itemDescription

        holder.binding.root.setOnClickListener {
            when(item.actionType) {

                ActionType.LOGOUT -> {

                    auth.signOut()

                    val intent = Intent(holder.binding.root.context, StartActivity::class.java)
                    it.context.startActivity(intent)
                    (it.context as? Activity)?.finish()

                }

                ActionType.NONE -> {
                    //NONE
                }
            }
        }
    }
}