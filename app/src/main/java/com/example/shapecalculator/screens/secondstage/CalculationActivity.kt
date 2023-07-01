package com.example.shapecalculator.screens.secondstage

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.shapecalculator.R
import com.example.shapecalculator.databinding.ActivityCalculationBinding

class CalculationActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityCalculationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        val intent = intent
        val shape = intent.getStringExtra("shape")
        val checkArea: Boolean by lazy { intent.getBooleanExtra("isAreaChecked", false) }
        val checkPerimeter: Boolean by lazy { intent.getBooleanExtra("isPerimeterChecked", false) }
        val calcIntent: Intent = Intent(this, PutDimensionsFragment::class.java)
        calcIntent.putExtra("shape", shape)
        calcIntent.putExtra("checkArea", checkArea)
        calcIntent.putExtra("checkPerimeter", checkPerimeter)

        binding = ActivityCalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_calculation)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_calculation)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}