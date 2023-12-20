package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.database.DBHelper;
import com.example.myapplication.database.User;

public class Formactivity extends AppCompatActivity {

    TextView name, age, mnumber;
    RadioButton male, female;

    Button submit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formactivity);

        name = findViewById(R.id.Name);
        age = findViewById(R.id.Age);
        mnumber = findViewById(R.id.editTextMobile);
        male = findViewById(R.id.radioButtonMale);
        female = findViewById(R.id.radioButtonFemale);
        submit = findViewById(R.id.Submit);
        submit.setOnClickListener(view -> {

            DBHelper dbHelper = new DBHelper(this);
            User u = new User();
            u.setName(name.getText().toString());
            u.setAge(Integer.parseInt( age.getText().toString()));
            u.setmNumber(Integer.parseInt(mnumber.getText().toString()));
            String gender = male.isChecked() ? "Male" : "Female";
            u.setGender(gender);
            
            long  r = dbHelper.insert(u);
            
            if(r>0){
                Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show();
            }

            startActivity(new Intent(this,MainActivity.class));
            

        });

    }
}