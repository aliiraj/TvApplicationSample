package com.example.tvapplicationsample.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapplicationsample.R

class HomeViewTypesAdapter(
    private val viewTypeList: List<HomeViewTypeModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (isHeaderViewType(position)) HomeViewTypes.Header.ordinal
        else HomeViewTypes.Row.ordinal
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HomeViewTypes.Header.ordinal)
            HeaderViewHolder(inflateLayout(R.layout.header_layout, viewGroup))
        else
            RowViewHolder(inflateLayout(R.layout.row_layout, viewGroup))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isHeaderViewType(position)) {
            (holder as HeaderViewHolder).apply {
                textView.text = (viewTypeList[position].data as String)
            }
        } else {
            (holder as RowViewHolder).apply {
                val row = viewTypeList[position].data as RowHomeViewTypeModel
                textView.text = row.title
                val adapterNew = MovieAdapter(row.items)
                rvMovies.adapter = adapterNew
            }
        }
    }

    private fun isHeaderViewType(position: Int) =
        viewTypeList[position].type == HomeViewTypes.Header

    override fun getItemCount() = viewTypeList.size

    inner class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<View>(R.id.headerTitle) as TextView
    }

    inner class RowViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<View>(R.id.row_header) as TextView
        val rvMovies = view.findViewById<View>(R.id.rvMovies) as RecyclerView
    }

    private fun inflateLayout(layoutId: Int, viewGroup: ViewGroup) =
        LayoutInflater.from(viewGroup.context).inflate(layoutId, viewGroup, false)
}