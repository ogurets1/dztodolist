package com.example.todolist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView1);
        EditText userData = findViewById(R.id.user_data);
        Button button = findViewById(R.id.button);
        ArrayList<String> todos = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String text = listView.getItemAtPosition(i).toString();
            adapter.remove(text);
            Toast.makeText(this, "Task removed: " + text, Toast.LENGTH_LONG).show();
        });

        button.setOnClickListener(v -> {
            String text = userData.getText().toString().trim();
            if (!text.isEmpty()) {
                adapter.insert(text, 0);
                userData.getText().clear();
            }
        });
    }
}