package com.example.gojektemp.pagination

import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView

class LoadAdapter : LoadStateAdapter<LoadAdapter.viewHolder>() {

    class viewHolder(view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onBindViewHolder(holder: viewHolder, loadState: LoadState) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): viewHolder {
        TODO("Not yet implemented")
    }
}