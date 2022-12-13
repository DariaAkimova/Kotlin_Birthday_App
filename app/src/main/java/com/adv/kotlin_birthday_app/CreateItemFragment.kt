package com.adv.kotlin_birthday_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.adv.kotlin_birthday_app.databinding.FragmentCreateItemBinding
import com.adv.kotlin_birthday_app.room.FriendEntity

class CreateItemFragment : Fragment() {

    lateinit var binding: FragmentCreateItemBinding
    lateinit var viewModel: FriendsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateItemBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[FriendsViewModel::class.java]

        return binding.root
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBtn.setOnClickListener {

            var nameText = binding.editName.text.toString().trim()
            var dateText = binding.editDate.text.toString().trim()
            var friendItem = FriendEntity(id, name = nameText, date = dateText)

            viewModel.insert(friendItem)

            Navigation.findNavController(it)
                .navigate(R.id.action_createItemFragment_to_listFragment)
        }

          binding.cancelBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_createItemFragment_to_listFragment)
        }

          }

}