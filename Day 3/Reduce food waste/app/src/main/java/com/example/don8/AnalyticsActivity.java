package com.example.don8;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;

public class AnalyticsActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    private ArrayList<String> xLabel = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analytics_view);
        // init analytics
        // mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_history:
                        startActivity(new Intent(AnalyticsActivity.this, HistoryActivity.class));
                        break;
                    case R.id.action_data:
                        //startActivity(new Intent(AnalyticsActivity.this, AnalyticsActivity.class));                        break;
                    case R.id.action_donate:
                        startActivity(new Intent(AnalyticsActivity.this, ConfirmationActivity.class));                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(AnalyticsActivity.this, ProfileActivity.class));
                        break;
                }
                return true;
            }
        });

        xLabel.add("Jan");
        xLabel.add("Feb");
        xLabel.add("Mar");
        xLabel.add("Apr");
        xLabel.add("May");
        xLabel.add("Jun");
        xLabel.add("Jul");

        drawChart();

    }

    // TODO: import bar chart and draw
    private void drawChart() {
        BarChart barChart = findViewById(R.id.analytics_bar_chart);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);

        // empty description
        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);

        barChart.setMaxVisibleValueCount(50);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(false);

        XAxis xl = barChart.getXAxis();
        xl.setDrawLabels(true);
        xl.setDrawGridLines(false);
        xl.setGranularity(1f);

        xl.setValueFormatter(new IndexAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xLabel.get((int)value);
            }
        });

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setSpaceTop(30f);
        leftAxis.setDrawLabels(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.getLegend().setEnabled(false);

        // placing data into graph
        float barWidth = 0.46f;

        int startLoc = 0;
        int endLoc = 5;

        List<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for(int i = startLoc; i < endLoc; i++) {
            yVals1.add(new BarEntry(i, AnalyticsActivity.randomInt(50)));
        }

        BarDataSet set1;

        set1 = new BarDataSet(yVals1, "Sample Data");
        set1.setDrawIcons(false);
        set1.setDrawValues(false);
        set1.setColor(Color.rgb(28,177,230));


        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);
        barChart.setData(data);

        barChart.getBarData().setBarWidth(barWidth);
        barChart.invalidate();

    }

    public static int randomInt(int end) { // 0 to end
        double randomDouble = -1;
        int randomInt = -1;
        do {
            randomDouble = Math.random();
            randomDouble = randomDouble * end;
            randomInt = (int) randomDouble;
        } while(randomInt <= 15 || randomInt >= (end - 10) );
        return randomInt;
    }

    // TODO: setup function and send analytics
    /*
    public void click() {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.PRICE, );

        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
    */
}
