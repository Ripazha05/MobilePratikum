package com.example.pratikummobilerifa.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.pratikummobilerifa.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view = binding.root

        val data = Messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        view.setOnClickListener {
            Toast.makeText(
                context,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
