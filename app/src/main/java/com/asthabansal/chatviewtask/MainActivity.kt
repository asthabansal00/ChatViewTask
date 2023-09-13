package com.asthabansal.chatviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.asthabansal.chatviewtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var chatlist = arrayListOf<chatDataClass>()
    lateinit var adapter: RecyclerAdapter
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RecyclerAdapter(chatlist)
        binding.btnSend.setOnClickListener {
            chatlist.add(chatDataClass(binding.etTypeMessage.text.toString()))
        }
    }
}