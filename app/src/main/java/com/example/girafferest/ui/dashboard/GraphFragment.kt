package com.example.girafferest.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.girafferest.R
import com.intrusoft.scatter.ChartData
import com.intrusoft.scatter.PieChart
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries


class GraphFragment : Fragment() {


    private lateinit var graph: GraphView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()
        drawGraph()
        drawPieChart()
    }


    private fun init() {
        graph = requireView().findViewById(R.id.graph)
    }
//Функція y = x^3 на проміжку x ∈ [-3; 3];
//Кільце кругової діаграми із секторами, що займають відповідний відсоток кола та мають відповідний колір: 15% (жовтий), 25% (коричневий), 45% (сірий), 10% (червоний), 5% (фіолетовий).
    private fun drawPieChart() {
        val pieChart = requireView().findViewById(R.id.pie_chart) as PieChart
        val data = ArrayList<ChartData>()
        data.add(ChartData("Yellow 15%", 15f, Color.WHITE, Color.YELLOW))
        data.add(ChartData("Brown 25%", 25f, Color.WHITE, Color.parseColor("#8B4513")))
        data.add(ChartData("Gray 30%", 45f, Color.WHITE, Color.GRAY))
        data.add(ChartData("Red 10%", 10f, Color.WHITE, Color.RED))
        data.add(ChartData("Purple 5%", 5f, Color.WHITE, Color.parseColor("#800080")))
        pieChart.setChartData(data)
    }

    private fun drawGraph() {
        val start = -3.0
        val end = 3.0
        val maxPoints = 100
        val arrOfX: DoubleArray = funcX(start, end, maxPoints)
        val arrOfY = DoubleArray(maxPoints) { graphFun(arrOfX[it]) }
        val series = LineGraphSeries<DataPoint>()

        for (i in 0 until maxPoints)
            series.appendData(DataPoint(arrOfX[i], arrOfY[i]), false, arrOfX.size)

        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.setMaxX(end)
        graph.viewport.setMinX(start)
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.setMaxY(27.1)
        graph.viewport.setMinY(-27.1)
        graph.addSeries(series)
    }

    private fun graphFun(x: Double) = x*x*x

    private fun funcX(start: Double, stop: Double, num: Int) =
        DoubleArray(num) { start + it * ((stop - start) / (num - 1)) }
}


