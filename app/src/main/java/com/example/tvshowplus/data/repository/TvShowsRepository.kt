package com.example.tvshowplus.data.repository

import com.example.tvshowplus.data.service.ApiService
import javax.inject.Inject

class TvShowsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getTvShows() = apiService.getTvShows()
}