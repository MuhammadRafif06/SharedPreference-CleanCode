package com.rafif.sharedpreferencecleancode

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rafif.sharedpreferencecleancode.databinding.ActivityMainBinding
import com.rafif.sharedpreferencecleancode.helper.Constant
import com.rafif.sharedpreferencecleancode.helper.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceHelper = PreferenceHelper(this)

        binding.btnLogin.setOnClickListener { onClick()

        }
    }

    private fun onClick() {
        if (binding.inputEmail.text.isNotEmpty() && binding.inputPassword.text.isNotEmpty()){
            preferenceHelper.put(Constant.PREF_EMAIL, binding.inputEmail.text.toString())
            preferenceHelper.put(Constant.PREF_PASSWORD, binding.inputPassword.text.toString())
            preferenceHelper.put(Constant.PREF_IS_LOGIN, true)
            moveActivity()
        }
    }


    private fun moveActivity(){
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        if (preferenceHelper.getBoolean(Constant.PREF_IS_LOGIN)){
            moveActivity()
        }
    }
}