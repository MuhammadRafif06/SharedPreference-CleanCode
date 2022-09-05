package com.rafif.sharedpreferencecleancode

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rafif.sharedpreferencecleancode.databinding.ActivityHomeBinding
import com.rafif.sharedpreferencecleancode.helper.Constant
import com.rafif.sharedpreferencecleancode.helper.PreferenceHelper

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceHelper = PreferenceHelper(this)
        binding.textViewEmail.text = preferenceHelper.getString(Constant.PREF_EMAIL)
        binding.btnLogout.setOnClickListener { onClick() }
    }

    private fun onClick() {
        preferenceHelper.clear()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}