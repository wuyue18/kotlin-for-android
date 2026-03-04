package com.example.activitytest

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val btn = findViewById<Button>(R.id.btn1)
        btn.setOnClickListener {
            Toast.makeText(this, "111", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> Toast.makeText(this, "点击add", Toast.LENGTH_SHORT).show()

            R.id.delete -> Toast.makeText(this, "点击delete", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}