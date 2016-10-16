package growth.garvan.com.au.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.addMeasurementsButton)
    public void addMeasurementClicked(){
        Intent intent = new Intent(this,MeasurementActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.createProfileButton)
    public void createProfiledClicked(){
        Intent intent = new Intent(this,CreateProfileActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.growthChartButton)
    public void growthChartClicked(){
        Intent intent = new Intent(this, ChartActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.newsButton)
    public void newsClicked(){

    }


}
