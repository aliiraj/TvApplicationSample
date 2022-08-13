package com.example.tvapplicationsample.presentation.home

import com.example.tvapplicationsample.data.models.Movie

data class RowHomeViewTypeModel(
    val title: String,
    val items: List<Movie>
)