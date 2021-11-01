package com.example.businnesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.businnesscard.App
import com.example.businnesscard.R
import com.example.businnesscard.data.BusinessCard
import com.example.businnesscard.databinding.ActivityAddCardBinding


class AddCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.xButton.setOnClickListener {
            finish()
        }
        binding.addConfirmButton.setOnClickListener {
            val businessCard = BusinessCard (
                name = binding.newName.editText?.text.toString(),
                company = binding.newCompany.editText?.text.toString(),
                phone = binding.newPhone.editText?.text.toString(),
                email = binding.newEmail.editText?.text.toString(),
                background = binding.newColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}