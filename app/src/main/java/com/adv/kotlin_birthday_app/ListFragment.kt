package com.adv.kotlin_birthday_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.room.Room
import com.adv.kotlin_birthday_app.databinding.FragmentListBinding
import com.adv.kotlin_birthday_app.room.FriendDataDao
import com.adv.kotlin_birthday_app.room.LocalDb
import kotlin.random.Random

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var dao: FriendDataDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        val room = Room.databaseBuilder(requireContext(), LocalDb::class.java, "friendData").build()
        dao = room.friendDataDao()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FriendsListAdapter()

//        binding.recyclerView.adapter = adapter


//        adapter.updateList(dao.getAll() as MutableList<Item>)


        binding.addBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_listFragment_to_createItemFragment)
        }

        binding.toTextBtn.setOnClickListener {
            val randomIds = List(1) { Random.nextInt(1, 100) }
            var randomId = randomIds.joinToString().toInt()

            Navigation.findNavController(it)
                .navigate(R.id.action_listFragment_to_randomTextFragment)
        }
    }
}
