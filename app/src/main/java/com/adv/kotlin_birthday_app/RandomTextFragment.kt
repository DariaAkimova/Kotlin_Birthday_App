package com.adv.kotlin_birthday_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.adv.kotlin_birthday_app.api.TextResponse
import com.adv.kotlin_birthday_app.api.TextRestApi
import com.adv.kotlin_birthday_app.databinding.FragmentRandomTextBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

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

        binding.newTextBtn.setOnClickListener {

        var textService = TextRestApi.getService()

        val randomIds = List(1) { Random.nextInt(1, 100) }
        var randomId = randomIds.joinToString().toInt()

        textService.getById(randomId).enqueue(object: Callback<TextResponse> {
            override fun onResponse(
                call: Call<TextResponse>,
                response: Response<TextResponse>
            ) {

                binding.randomText.text = response.body()?.body.toString()
            }

            override fun onFailure(call: Call<TextResponse>, t: Throwable) {
                binding.randomText.text = "Ничего нет.. Придется придумывать самому."
            }
        })
    }

        binding.backBtn.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_randomTextFragment_to_listFragment)
        }

    }
}