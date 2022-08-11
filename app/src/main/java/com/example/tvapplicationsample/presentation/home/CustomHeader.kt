package com.example.tvapplicationsample.presentation.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.leanback.widget.TitleViewAdapter
import com.example.tvapplicationsample.R

class CustomTitleView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(context, attrs, defStyle), TitleViewAdapter.Provider {

    private var mTitleView: TextView
    private lateinit var mSearchOrbView: View

    private val mTitleViewAdapter: TitleViewAdapter = object : TitleViewAdapter() {
        override fun getSearchAffordanceView(): View {
            return mSearchOrbView
        }

        override fun setTitle(titleText: CharSequence) {
            this@CustomTitleView.setTitle(titleText)
        }
    }

    fun setTitle(title: CharSequence?) {
        if (title != null) {
            mTitleView.text = title
            mTitleView.visibility = VISIBLE
        }
    }

    override fun getTitleViewAdapter(): TitleViewAdapter {
        return mTitleViewAdapter
    }

    init {
        val root: View = LayoutInflater.from(context).inflate(R.layout.custom_header_layout, this)
        mTitleView = root.findViewById<View>(R.id.title_tv) as TextView
        mSearchOrbView = root.findViewById(R.id.search_orb)
    }
}