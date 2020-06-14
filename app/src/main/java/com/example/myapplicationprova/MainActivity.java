package com.example.myapplicationprova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Person x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayList<Person> persons = new ArrayList<>();
        x = new Person("ciaopippo");
        Log.d("loog", "nome: "+ x.getNome());

        Button b = findViewById(R.id.button);
        if(b==null) Log.d("loog","b is null");

        try {
            b.setOnClickListener(this);
        }
        catch (Exception e){
            Log.d("loog","b is null ");
            e.printStackTrace();
        }

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("loog ","Cliccato bootnoe 2 implicito");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Log.d("loog","Click primo bootone");
                break;
            case R.id.button2:
                Log.d("loog","Click secondo bootone");
                break;
            default:
                Log.d("loog","default case");
        }
        Button b = (Button)v;
        b.setText(x.getNome());

        EditText ed = findViewById(R.id.editText);
//        ed.getText();

        Intent i = new Intent(this, Main4Activity.class);
        i.putExtra("nome", ed.getText().toString());
        startActivity(i);
    }
}
