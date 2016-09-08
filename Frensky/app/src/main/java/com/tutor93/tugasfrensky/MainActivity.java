package com.tutor93.tugasfrensky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //define button
    Button btnGrid, btnList;

    LinearLayout gridView, listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (LinearLayout) findViewById(R.id.gridView);
        listView = (LinearLayout) findViewById(R.id.listView);

        btnGrid = (Button) findViewById(R.id.gridBtn);
        btnList = (Button) findViewById(R.id.btnList);

        btnGrid.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == btnGrid) {
            listView.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
        } else if (view == btnList) {
            gridView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
    }
}
