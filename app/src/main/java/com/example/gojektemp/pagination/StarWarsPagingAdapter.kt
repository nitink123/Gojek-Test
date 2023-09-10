package com.example.gojektemp.pagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gojektemp.R
import com.example.gojektemp.models.Results

class StarWarsPagingAdapter : PagingDataAdapter<Results, StarWarsPagingAdapter.StarWarsViewHolder>(
    COMPARATOR) {

    private var searchQuery: String = ""

    class StarWarsViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val mText: TextView = view.findViewById(R.id.starwars_name)
        val mdefault : ImageView = view.findViewById(R.id.default_image)
    }

    override fun onBindViewHolder(holder: StarWarsViewHolder, position: Int) {
        val item = getItem(position)

        // Check if there's a search query
        if (searchQuery.isNotEmpty()) {
            if (item?.name?.contains(searchQuery, true) == true) {
                // If the item matches the search query, display the item and hide the default image
                holder.mText.text = item.name
                holder.itemView.visibility = View.VISIBLE
                holder.mdefault.visibility = View.GONE
            } else {
                // If the item does not match the search query, hide the item and show the default image
                holder.itemView.visibility = View.GONE
                holder.mdefault.visibility = View.VISIBLE
            }
        } else {
            // If there's no search query
            if (item != null) {
                // If there's an item at this position, display it and hide the default image
                holder.mText.text = item.name
                holder.itemView.visibility = View.VISIBLE
                holder.mdefault.visibility = View.GONE
            } else {
                // If there's no item at this position, hide the item and show the default image
                holder.itemView.visibility = View.GONE
                holder.mdefault.visibility = View.VISIBLE
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.starwars_item, parent, false)
        return StarWarsViewHolder(view)
    }

    fun setSearchQuery(query: String) {
        searchQuery = query
        notifyDataSetChanged()
    }

    companion object{
        private val COMPARATOR = object : DiffUtil.ItemCallback<Results>(){
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem == newItem
            }
        }
    }
}

