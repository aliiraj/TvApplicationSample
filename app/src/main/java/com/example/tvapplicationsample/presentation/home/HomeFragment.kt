package com.example.tvapplicationsample.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.tvapplicationsample.R
import com.example.tvapplicationsample.data.MovieList

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvHomeTypes: RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = HomeViewTypesAdapter(getHomeViewTypes())
        rvHomeTypes.adapter = adapter
    }

    private fun getHomeViewTypes(): List<HomeViewTypeModel> {
        val arrayList = ArrayList<HomeViewTypeModel>()
        arrayList.add(
            HomeViewTypeModel(
                HomeViewTypes.Header,
                getString(R.string.browse_title)
            )
        )
        arrayList.add(
            HomeViewTypeModel(
                HomeViewTypes.Row,
                RowHomeViewTypeModel("عنوان ۱", MovieList.list)
            )
        )
        arrayList.add(
            HomeViewTypeModel(
                HomeViewTypes.Row,
                RowHomeViewTypeModel("عنوان 2", MovieList.list)
            )
        )
        return arrayList
    }

}

