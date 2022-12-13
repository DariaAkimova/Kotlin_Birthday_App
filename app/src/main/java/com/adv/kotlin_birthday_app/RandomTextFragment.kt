package com.adv.kotlin_birthday_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.adv.kotlin_birthday_app.databinding.FragmentRandomTextBinding

class RandomTextFragment : Fragment() {
    lateinit var binding: FragmentRandomTextBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRandomTextBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val adapter = FriendsListAdapter()
//
//        binding.recyclerView.adapter = adapter


//        adapter.updateList(dao.getAll() as MutableList<Item>)


        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_randomTextFragment_to_listFragment)
        }

    }
}