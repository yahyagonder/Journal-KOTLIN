package com.yahyagonder.journalapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yahyagonder.journalapp.Adapter.JournalAdapter
import com.yahyagonder.journalapp.Model.JournalItem
import com.yahyagonder.journalapp.R
import com.yahyagonder.journalapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var adapter: JournalAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = JournalAdapter(getItemList())
        binding.journalsRV.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.journalsRV.adapter = adapter
        binding.journalsRV.setHasFixedSize(true)

    }

    private fun getItemList(): List<JournalItem> {

        val journalItems = listOf(JournalItem("WEEK ONE", "21 June 2024", R.drawable.one),
            JournalItem("WEEK TWO", "22 June 2024", R.drawable.two),
            JournalItem("WEEK THREE", "23 June 2024", R.drawable.three),
            JournalItem("WEEK FOUR", "24 June 2024", R.drawable.one),
            JournalItem("WEEK FIVE", "25 June 2024", R.drawable.two),
            JournalItem("WEEK SIX", "26 June 2024", R.drawable.three),
            JournalItem("WEEK SEVEN", "27 June 2024", R.drawable.one),
            JournalItem("WEEK EIGHT", "28 June 2024", R.drawable.two))

        return journalItems
    }
    
}