package com.yahyagonder.journalapp.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.yahyagonder.journalapp.Adapter.AboutAdapter
import com.yahyagonder.journalapp.Model.AboutItem
import com.yahyagonder.journalapp.Model.ActionType
import com.yahyagonder.journalapp.R
import com.yahyagonder.journalapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAboutBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser

        if (currentUser == null) {
            binding.accountText.text = "Anonymous User"
        } else {
            val email = currentUser.email
            binding.accountText.text = email
        }

        val adapter = AboutAdapter(getItemList())
        binding.aboutRV.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.aboutRV.adapter = adapter
        binding.aboutRV.setHasFixedSize(true)

    }

    private fun getItemList(): List<AboutItem> {

        val aboutItems = listOf(AboutItem(R.drawable.news_icon,"JOURNAL","1.0.0", ActionType.NONE),
            AboutItem(R.drawable.baseline_power_24,"LOGOUT","GOODBYE!", ActionType.LOGOUT))

        return aboutItems
    }

}