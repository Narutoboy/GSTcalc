package com.example.gstcalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView text= (TextView) findViewById(R.id.textView);

        String Id= getIntent().getStringExtra("btn");
        switch(Id){
            case "5":
                text.setText("5 % gst are applicable in ");
                break;
            case "12":
                text.setText("12% gst are applicable in ");
                break;
            case "18":
                text.setText("18 % gst are applicable in ");
                break;
            case "28":
                text.setText("5 % gst are applicable in ");
                break;
        }
    }
}
