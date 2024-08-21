package com.yahyagonder.journalapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yahyagonder.journalapp.Model.NewsItem
import com.yahyagonder.journalapp.databinding.NewsItemBinding

class NewsAdapter(private var newsItemList: List<NewsItem>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    class NewsViewHolder(val binding: NewsItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsItemList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsItemList[position]
        holder.binding.newsTitle.text = item.newsTitle
        holder.binding.newsDescription.text = item.newsDescription
        holder.binding.newsDate.text = item.newsDate
        holder.binding.newsImage.setImageResource(item.newsImage)
    }


}