package com.doops.backdrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    ImageView filterIcon;
    BottomSheetBehavior sheetBehavior;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("BackDrop");
        getSupportActionBar().setElevation(0);
        swipeRefreshLayout = findViewById(R.id.swiperefresh);

        filterIcon = findViewById(R.id.filterIcon);
        LinearLayout contentLayout = findViewById(R.id.contentLayout);

        sheetBehavior = BottomSheetBehavior.from(contentLayout);
        sheetBehavior.setFitToContents(false);
        sheetBehavior.setHideable(false);//prevents the boottom sheet from completely hiding off the screen
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);//initially state to fully expanded

        filterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleFilters();
            }
        });


    }

    private void toggleFilters() {
        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

}
