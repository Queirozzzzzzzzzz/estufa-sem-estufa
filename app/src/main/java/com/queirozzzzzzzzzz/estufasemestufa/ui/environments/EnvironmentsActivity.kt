package com.queirozzzzzzzzzz.estufasemestufa.ui.environments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.queirozzzzzzzzzz.estufasemestufa.databinding.ActivityEnvironmentsBinding
import com.queirozzzzzzzzzz.estufasemestufa.ui.environment.EnvironmentActivity

class EnvironmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnvironmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnvironmentsBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
    }

    fun startEnvironment(view: View) {
        val intent = Intent(this, EnvironmentActivity::class.java)
        startActivity(intent)
    }
}
