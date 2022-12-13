package com.adv.kotlin_birthday_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adv.kotlin_birthday_app.databinding.ItemLayoutBinding

class FriendsListAdapter(): RecyclerView.Adapter<FriendsListViewHolder>() {

    var list = mutableListOf<Item>()

    fun updateList (list: MutableList<Item>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsListViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return FriendsListViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendsListViewHolder, position: Int) {
        holder.binding.item = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class FriendsListViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
    val binding = ItemLayoutBinding.bind(ItemView)
}