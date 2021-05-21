package com.example.girafferest


import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_book
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //  task1_2()
    }

    fun changeGraph(view: View) {
        val graph = findViewById<GraphView>(R.id.graph)
        val pieChart = findViewById<PieChart>(R.id.pie_chart)

        if (graph.visibility == View.GONE) {
            graph.visibility = View.VISIBLE
            pieChart.visibility = View.GONE
        } else {
            graph.visibility = View.GONE
            pieChart.visibility = View.VISIBLE
        }
    }

//    fun onDeleteBoo(view: View){
//
//
//    }


    fun randomValue(a: Int): Int = when ((0..6).random()) {
        1 -> (Math.ceil(a.toFloat() * 0.7)).toInt()
        2 -> (Math.ceil(a.toFloat() * 0.9)).toInt()
        3, 4, 5 -> a
        6 -> 0
        else -> 0
    }


}