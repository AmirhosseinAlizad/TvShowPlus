package com.example.tvshowplus.data.service

import com.example.tvshowplus.data.model.TvShowsItem
import com.example.tvshowplus.data.model.TvShowsResponse
import com.example.tvshowplus.utils.Constance
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(value = Constance.END_POINT)
    suspend fun getTvShows(): Response<TvShowsResponse>
}