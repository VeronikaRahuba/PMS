package com.example.girafferest

import CoordinateVR
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
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


    fun task1_2() {
        // Частина 0
        var x = CoordinateVR()
        var y = CoordinateVR(3, 3, 3, Direction.LENGTH)
        var w = CoordinateVR(9, 7, -17, Direction.LENGTH)
        var z = CoordinateVR(17, 23, -153, Direction.WIDTH)
        var v = CoordinateVR(53, 37, 179, Direction.WIDTH)



        println("")

        println(z.getDegreesSecondsMinutesDirection())

        println(y.getDegreesSecondsMinutesDirectionDouble())

        println(z.averageCoordinate(v).toString())
        println(x.averageCoordinateTwoParameters(y, w).toString())


        // Частина 1

// Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."
// Завдання 1
// Заповніть словник, де:
// - ключ – назва групи
// - значення – відсортований масив студентів, які відносяться до відповідної групи
        var studentsStr =
            "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82;" +
                    " Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; " +
                    "Кочерук Давид - ІВ-83; Лихацька Юлія- ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82;" +
                    " Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; " +
                    "Роман Олександр - ІО-82;  Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; " +
                    "Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81;" +
                    " Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82"
// Ваш код починається тут
        var students = ArrayList<String>()
        students.addAll(studentsStr.split(";"))
        var studentsDirectory = HashMap<String, MutableList<String>>()
        studentsDirectory.toMutableMap()
        students.forEach {
            if (studentsDirectory.containsKey(it.split("- ")[1])) {
                val arr = studentsDirectory[it.split("- ")[1]]!!.toMutableList()

                arr.add(it.split("- ")[0])
                studentsDirectory[it.split("- ")[1]] = arr

            } else {
                studentsDirectory[it.split("- ")[1]] = mutableListOf(it.split("- ")[0])
            }
        }
        studentsDirectory.forEach {
            it.value.sort()

            //  println(it.value)
        }
// Ваш код закінчується тут
        println("Завдання 1")
        println("test${studentsDirectory}")
        println()


        var point = ArrayList<Int>(listOf(12, 12, 12, 12, 12, 12, 12, 16))


// Завдання 2
// Заповніть словник, де:
// - ключ – назва групи
// - значення – словник, де:
//   - ключ – студент, який відносяться до відповідної групи
//   - значення – масив з оцінками студента (заповніть масив випадковими значеннями, використовуючи функцію `randomValue(maxValue: Int) -> Int`)

// Ваш код починається тут
        var studentPoints = HashMap<String, HashMap<String, MutableList<Int>>>()

        studentsDirectory.forEach() {
            val map = HashMap<String, MutableList<Int>>()
            it.value.forEach {
                val stPoits = ArrayList<Int>()
                for (i in point.indices)
                    stPoits.add(randomValue(point[i]))

                map[it] = stPoits

            }
            studentPoints.put(it.key, map)
        }
// Ваш код закінчується тут

        println("Завдання 2")
        println(studentPoints)
        println()

        // Завдання 3
// Заповніть словник, де:
// - ключ – назва групи
// - значення – словник, де:
//   - ключ – студент, який відносяться до відповідної групи
//   - значення – сума оцінок студента

        var sumPoints = HashMap<String, HashMap<String, Int>>()

// Ваш код починається тут
        studentPoints.forEach() {
            val map = HashMap<String, Int>()
            it.value.forEach {
                var sum = it.value.sum()
                map[it.key] = sum

            }
            sumPoints.put(it.key, map)
        }


// Ваш код закінчується тут

        println("Завдання 3")
        println(sumPoints)
        println()

        // Завдання 4
// Заповніть словник, де:
// - ключ – назва групи
// - значення – середня оцінка всіх студентів групи

        var groupAvg = HashMap<String, Double>()

// Ваш код починається тут
        sumPoints.forEach {
            val arrayOfPoints = ArrayList<Int>()
            it.value.forEach {
                arrayOfPoints.add(it.value)
            }
            groupAvg[it.key] = arrayOfPoints.average()
        }


// Ваш код закінчується тут

        println("Завдання 4")
        println(groupAvg)
        println()

        // Завдання 5
// Заповніть словник, де:
// - ключ – назва групи
// - значення – масив студентів, які мають >= 60 балів

        var passedPerGroup = HashMap<String, MutableList<String>>()

// Ваш код починається тут
        sumPoints.forEach {
            val arrayOfPoints = ArrayList<String>()
            it.value.forEach {
                if (it.value >= 60)
                    arrayOfPoints.add(it.key)
            }
            passedPerGroup[it.key] = arrayOfPoints
        }


// Ваш код закінчується тут

        println("Завдання 5")
        println(passedPerGroup)
        // val test = CoordinateVR(-1,-1,1)

    }


    fun randomValue(a: Int): Int = when ((0..6).random()) {
        1 -> (Math.ceil(a.toFloat() * 0.7)).toInt()
        2 -> (Math.ceil(a.toFloat() * 0.9)).toInt()
        3, 4, 5 -> a
        6 -> 0
        else -> 0
    }


}