package com.yahyagonder.journalapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.size
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rajat.pdfviewer.PdfViewerActivity
import com.rajat.pdfviewer.PdfViewerActivity.Companion.launchPdfFromUrl
import com.rajat.pdfviewer.util.saveTo
import com.yahyagonder.journalapp.Model.JournalItem
import com.yahyagonder.journalapp.R
import com.yahyagonder.journalapp.View.DetailsFragmentDirections
import com.yahyagonder.journalapp.databinding.JournalItemBinding

class JournalAdapter(val journalItemList: List<JournalItem>): RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {

    class JournalViewHolder(val binding: JournalItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val binding = JournalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return JournalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return journalItemList.size
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        val item = journalItemList[position]
        holder.binding.journalImage.setImageResource(item.journalImage)
        holder.binding.journalName.text = item.journalName
        holder.binding.journalDate.text = item.journalDate

        holder.binding.journalCardView.setOnClickListener {
            val action = DetailsFragmentDirections.actionDetailsFragmentToViewerFragment(item)
            Navigation.findNavController(it).navigate(action)
        }

    }




}