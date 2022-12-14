package com.adv.kotlin_birthday_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adv.kotlin_birthday_app.databinding.ItemLayoutBinding
import com.adv.kotlin_birthday_app.room.FriendEntity

class FriendsListAdapter : RecyclerView.Adapter<FriendsListAdapter.ViewHolder>() {

    var items: List<FriendEntity> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
            }

    private var itemClick: (FriendEntity) -> Unit = {}
    fun itemClick(listener: (FriendEntity) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
        }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemLayoutBinding.bind(view)

    }
}

//class FriendsListAdapter(): RecyclerView.Adapter<FriendsListViewHolder>() {
//
//    var list = mutableListOf<Item>()
//
//    fun updateList (list: MutableList<Item>) {
//        this.list = list
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsListViewHolder {
//
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
//        return FriendsListViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: FriendsListViewHolder, position: Int) {
//        holder.binding.item = list[position]
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//}
//
//class FriendsListViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
//    val binding = ItemLayoutBinding.bind(ItemView)
//}
