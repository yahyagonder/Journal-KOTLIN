package com.yahyagonder.journalapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yahyagonder.journalapp.Model.CarouselItem
import com.yahyagonder.journalapp.databinding.CarouselItemBinding

class CarouselAdapter(private val carouselList: List<CarouselItem>): RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    class CarouselViewHolder(val binding: CarouselItemBinding): RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CarouselViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return carouselList.size
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = carouselList[position]
        holder.binding.carouselImage.setImageResource(item.imageRes)
        holder.binding.carouselText.text = item.imageText

    }


}