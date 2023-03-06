package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val todo: MutableList<String> = mutableListOf()
    var ind = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addB.setOnClickListener{
            todo.add(binding.taskIn.text.toString())
        }
        binding.nextB.setOnClickListener{
            if (todo.size <= 0){
                binding.taskOut.text = "Your tasks will be displayed here"
                return@setOnClickListener
            }
            ind += 1
            if (ind >= todo.size){
                ind = 0
            }
            binding.taskOut.text = todo[ind]



        }
        binding.prevB.setOnClickListener{
            if (todo.size <= 0){
                binding.taskOut.text = "Your tasks will be displayed here"
                return@setOnClickListener
            }
            ind -= 1
            if (ind <= 0){
                ind = todo.size-1
            }
            binding.taskOut.text = todo[ind]
        }






    }
}
