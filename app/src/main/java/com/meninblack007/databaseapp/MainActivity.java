package com.meninblack007.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by men_in_black007 on 15/11/16.
 */

public class MainActivity extends AppCompatActivity {

    private SQLiteHelper sqLiteHelper;
    private EditText studentName, studentEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteHelper = new SQLiteHelper(this);
        studentName = (EditText) findViewById(R.id.name);
        studentEmail = (EditText) findViewById(R.id.email);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = studentName.getText().toString();
                String emailId = studentEmail.getText().toString();
                Log.d("MainActivity", name + " " + emailId);
                studentName.setText("");
                studentEmail.setText("");
                Toast.makeText(getApplicationContext(), "Your data has been saved in database.", Toast.LENGTH_SHORT).show();
                sqLiteHelper.addNewStudent(new Student(name, emailId));
            }
        });
    }
}