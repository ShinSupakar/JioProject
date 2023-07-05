package com.example.loginsignup

import android.content.res.Resources.NotFoundException
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> {FirstFragment()}
            1 -> {SecondFragment()}
            else -> { throw NotFoundException("Position not found")}
        }
    }
}