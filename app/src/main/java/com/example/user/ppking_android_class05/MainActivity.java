package com.example.user.ppking_android_class05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private My_View myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (My_View)findViewById(R.id.myview);
    }
    public void clear(View v){
        myView.clear();
    }
}
