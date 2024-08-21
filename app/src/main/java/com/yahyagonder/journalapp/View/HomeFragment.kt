package com.yahyagonder.journalapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yahyagonder.journalapp.Adapter.CarouselAdapter
import com.yahyagonder.journalapp.Adapter.NewsAdapter
import com.yahyagonder.journalapp.Model.CarouselItem
import com.yahyagonder.journalapp.Model.NewsItem
import com.yahyagonder.journalapp.R
import com.yahyagonder.journalapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var carouselAdapter: CarouselAdapter
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselAdapter = CarouselAdapter(getCarouselList())
        binding.highlightsRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.highlightsRV.adapter = carouselAdapter
        binding.highlightsRV.setHasFixedSize(true)

        newsAdapter = NewsAdapter(getNewsList())
        binding.newsRV.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.newsRV.adapter = newsAdapter
        binding.newsRV.setHasFixedSize(true)

    }

    private fun getCarouselList(): List<CarouselItem> {

        val carouselItems = listOf(
            CarouselItem("TEXT ONE",R.drawable.one),
            CarouselItem("TEXT TWO", R.drawable.two),
            CarouselItem("TEXT THREE", R.drawable.three),)

        return carouselItems
    }

    private fun getNewsList(): List<NewsItem> {
        return listOf()
    }

}