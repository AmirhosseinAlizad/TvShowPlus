package com.example.tvshowplus.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tvshowplus.DetailsActivity
import com.example.tvshowplus.databinding.ActivityMainBinding
import com.example.tvshowplus.databinding.MovieItemBinding
import com.example.tvshowplus.ui.adapter.TvShowsAdapter
import com.example.tvshowplus.ui.viewmodel.TvShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2:MovieItemBinding
    private val viewModel: TvShowsViewModel by viewModels()
    private lateinit var showsAdapter: TvShowsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    private fun bindViews() {
        showsAdapter = TvShowsAdapter()
        viewModel.responseTvShows.observe(this) { response ->
            showsAdapter.tvShowsModel = response
        }
        binding.recycler.apply {
            adapter = showsAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }
}