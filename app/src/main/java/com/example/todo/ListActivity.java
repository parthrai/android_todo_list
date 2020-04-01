package com.example.todo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lv = (ListView) findViewById(R.id.lvTasks);

        ArrayList<String> tasksFromDb = new ArrayList<>();

        DBHelper myDb = new DBHelper(this);

        Cursor data  = myDb.getData();

        while(data.moveToNext()){

            tasksFromDb.add(data.getString(1));
        }

        ArrayAdapter bind = new ArrayAdapter(this,R.layout.tasks,R.id.tvTask,tasksFromDb);

        lv.setAdapter(bind);







    }
}
