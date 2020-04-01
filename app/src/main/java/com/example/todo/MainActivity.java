package com.example.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addTask(View v){

        EditText task = (EditText) findViewById(R.id.ETtask);

        if(task.getText().length() == 0){
            Toast.makeText(this,"Please enter a valid task",Toast.LENGTH_LONG).show();
            return;
        }

        DBHelper myDb = new DBHelper(this);

        // ENTER THE INFO IN DB

       boolean result =  myDb.addData(task.getText().toString());

        if(result){
            Toast.makeText(this,"Task added!",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Task not added!",Toast.LENGTH_LONG).show();

        }

        task.setText("");




    }

    public void listTasks(View v){

        Intent i = new Intent(MainActivity.this,ListActivity.class);
        startActivity(i);
    }

}
