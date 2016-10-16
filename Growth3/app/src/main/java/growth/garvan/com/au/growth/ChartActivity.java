package growth.garvan.com.au.growth;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.EntryXComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mockMethod();
    }

    private void mockMethod(){
        //** GOES INTO METHOD FOR MAKING GRAPH- (e.g OnCreate)

        LineChart chart = (LineChart) findViewById(R.id.chart);

        ArrayList<Entry> entries = new ArrayList<Entry>();
        ArrayList<Entry> entries_avg = new ArrayList<Entry>();

        Entry d1e1 = new Entry(0f,7f );
        Entry d1e2 = new Entry(1f,11f );
        Entry d1e3 = new Entry(2f,18f );
        Entry d1e4 = new Entry(3f,20f );
        Entry d1e5 = new Entry(4f,22f );
        Entry d1e6 = new Entry(5f,23f );
        Entry d1e7 = new Entry(6f,24f );
        Entry d1e8 = new Entry(7f,24f );

        Entry d2e1 = new Entry(0f,3f );
        Entry d2e2 = new Entry(1f,5f);
        Entry d2e3 = new Entry(2f,10f);
        Entry d2e4 = new Entry(3f,14f);
        Entry d2e5 = new Entry(4f,16f );
        Entry d2e6 = new Entry(5f,17f);
        Entry d2e7 = new Entry(6f,18f);
        Entry d2e8 = new Entry(7f,18f);

        entries.add(d1e1);
        entries.add(d1e2);
        entries.add(d1e3);
        entries.add(d1e4);
        entries.add(d1e5);
        entries.add(d1e6);
        entries.add(d1e7);
        entries.add(d1e8);

        Collections.sort(entries, new EntryXComparator());

        entries_avg.add(d2e1);
        entries_avg.add(d2e2);
        entries_avg.add(d2e3);
        entries_avg.add(d2e4);
        entries_avg.add(d2e5);
        entries_avg.add(d2e6);
        entries_avg.add(d2e7);
        entries_avg.add(d2e8);

        Collections.sort(entries_avg, new EntryXComparator());

        LineDataSet dataSet1 = new LineDataSet(entries, "Average Height");
        dataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet1.setColor(ColorTemplate.rgb("#0a005a"));
        dataSet1.setCircleColor(ColorTemplate.rgb("#0a005a"));

        LineDataSet dataSet2 = new LineDataSet(entries_avg, "Patient Height");
        dataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet2.setColor(ColorTemplate.rgb("#0ac85a"));
        dataSet2.setCircleColor(ColorTemplate.rgb("#0ac85a"));

        // use the interface ILineDataSet
        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);

        LineData data = new LineData(dataSets);
        data.setValueTextSize(13f);

        // - X Axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(14f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(ColorTemplate.rgb("#000000"));
        xAxis.setEnabled(true);
        xAxis.disableGridDashedLine();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(true);
        xAxis.setAvoidFirstLastClipping(true);

        // - Y Axis
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setTextSize(14f);
        leftAxis.setTextColor(ColorTemplate.rgb("#000000"));
        leftAxis.setAxisMinValue(0f); // to set minimum yAxis
        leftAxis.enableGridDashedLine(5f, 5f, 0f);
        leftAxis.setDrawLimitLinesBehindData(true);
        leftAxis.setDrawGridLines(true);
        leftAxis.setDrawLabels(true);
        chart.getAxisRight().setEnabled(false);

//-----------------
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
//-----------------
        Legend l = chart.getLegend();
        l.setForm(Legend.LegendForm.SQUARE);
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setEnabled(true);
        l.setFormSize(10f); // set the size of the legend forms/shapes
        l.setTextSize(12f);
        l.setTextColor(ColorTemplate.rgb("#000000"));
        l.setXEntrySpace(5f); // set the space between the legend entries on the x-axis
        l.setYEntrySpace(5f); // set the space between the legend entries on the y-axis

        // set custom labels and colors
//-----------------
        chart.setDescription("Growth Chart - Patients Age plotted with respective ages");
        chart.setDescriptionTextSize(12f);
        chart.setDrawBorders(true);
        chart.setData(data);
        chart.invalidate();
    }

}
