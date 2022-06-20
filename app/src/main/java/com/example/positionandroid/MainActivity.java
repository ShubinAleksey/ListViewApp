package com.example.positionandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ListView listView = findViewById(R.id.listView);
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);
        CheckBox checkBox4 = findViewById(R.id.checkBox4);
        CheckBox checkBox5 = findViewById(R.id.checkBox5);

        final String[] techNames = new String[] {
                "Компьютер", "Ноутбук", "Лаптоп", "Телефон", "Планшет"
        };

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, techNames);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View itemClicked,
                                    int position,
                                    long id)
            {
                if(((TextView) itemClicked).getText() == "Компьютер")
                checkBox1.setChecked(!checkBox1.isChecked());
                else if(((TextView) itemClicked).getText() == "Ноутбук")
                checkBox2.setChecked(!checkBox2.isChecked());
                else if(((TextView) itemClicked).getText() == "Лаптоп")
                    checkBox3.setChecked(!checkBox3.isChecked());
                else if(((TextView) itemClicked).getText() == "Телефон")
                    checkBox4.setChecked(!checkBox4.isChecked());
                else
                    checkBox5.setChecked(!checkBox5.isChecked());
//                if(((TextView) itemClicked).getText() == "Компьютер")
//                    Toast.makeText(getApplicationContext(), "Компьютер", Toast.LENGTH_SHORT).show();
//                else if(((TextView) itemClicked).getText() == "Ноутбук")
//                    Toast.makeText(getApplicationContext(), "Ноутбук", Toast.LENGTH_SHORT).show();
//                else if(((TextView) itemClicked).getText() == "Лаптоп")
//                    Toast.makeText(getApplicationContext(), "Лаптоп", Toast.LENGTH_SHORT).show();
//                else if(((TextView) itemClicked).getText() == "Телефон")
//                    Toast.makeText(getApplicationContext(), "Телефон", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(getApplicationContext(), "Планшет", Toast.LENGTH_SHORT).show();
            }
        });

    }
}