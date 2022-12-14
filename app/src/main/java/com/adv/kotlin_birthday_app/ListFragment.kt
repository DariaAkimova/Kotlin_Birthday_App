package com.adv.kotlin_birthday_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.adv.kotlin_birthday_app.databinding.FragmentListBinding

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = FriendsListAdapter()

        binding.recyclerView.adapter = adapter

        var viewModel = ViewModelProvider(requireActivity())[FriendsViewModel::class.java]


        viewModel.getAll()?.observe(requireActivity()) {
            if (it.isEmpty()) {
                Toast.makeText(requireActivity(), "No data", Toast.LENGTH_SHORT).show()
            }
            adapter.items = it
        }

        binding.addBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_listFragment_to_createItemFragment)
        }

        binding.toTextBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_listFragment_to_randomTextFragment)
        }
    }
    }
