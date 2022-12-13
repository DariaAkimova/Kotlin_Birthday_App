package com.adv.kotlin_birthday_app

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.adv.kotlin_birthday_app.databinding.FragmentCreateItemBinding
import com.adv.kotlin_birthday_app.room.FriendDataDao
import com.adv.kotlin_birthday_app.room.LocalDb
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateItemFragment : Fragment() {

    lateinit var binding: FragmentCreateItemBinding
    lateinit var dao: FriendDataDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateItemBinding.inflate(inflater)
        val room = Room.databaseBuilder(requireContext(), LocalDb::class.java, "friendData").build()
        dao = room.friendDataDao()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBtn.setOnClickListener {

            var nameText = binding.editName.text.toString().trim()
            var dateText = binding.editDate.text.toString().trim()
            var friendItem = Item (id, name = nameText, date = dateText)

            GlobalScope.launch {
                dao.insert(friendItem)
            }

            //            if (nameText != null && dateText != null) {
//                GlobalScope.launch {
//                    dao.insert(friendItem)
//                }
//                Navigation.findNavController(it)
//                    .navigate(R.id.action_createItemFragment_to_listFragment)
//            } else {
//                Toast.makeText(requireActivity(), "name and date are required", Toast.LENGTH_SHORT).show()
//            }

            Navigation.findNavController(it)
                .navigate(R.id.action_createItemFragment_to_listFragment)
        }

        binding.cancelBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_createItemFragment_to_listFragment)
        }

        binding.toCalendarBtn.setOnClickListener {

            var title = binding.editName.text
            var packageManager = requireActivity().packageManager

            val intent = Intent(Intent.ACTION_INSERT).apply {
                data = CalendarContract.Events.CONTENT_URI
                putExtra(CalendarContract.Events.TITLE, title)
//                putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
//                putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }

}