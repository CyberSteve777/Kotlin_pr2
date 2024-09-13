package me.cybersteve.kotlin_pr2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import me.cybersteve.kotlin_pr2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view);
        binding.butt.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragment = FragmentNavigationApi()
            fragmentManager.beginTransaction().replace(R.id.main, fragment)
            .addToBackStack(null)
            .commit()
        }
    }
}