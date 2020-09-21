package org.caio.chartproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Column;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Cartesian pie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        components();
    }

    private void components() {
        pie = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("Clebinho", 10));
        data.add(new ValueDataEntry("Gilsinho", 20));
        data.add(new ValueDataEntry("Caio", 70));

        pie.column(data);
        pie.draw(false);

        AnyChartView anyChart = findViewById(R.id.chart);
        anyChart.setZoomEnabled(true);
        anyChart.setChart(pie);
    }

}