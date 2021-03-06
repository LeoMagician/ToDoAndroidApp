package com.app.leo.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.app.leo.todolistapp.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_TODO_ITEM = 100;
    List<Todo> todos;
    private ToDoListAdpter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (todos == null) {
            todos = new ArrayList<>();
        }

        setupUI(todos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == ADD_TODO_ITEM) {
            Todo todo = data.getParcelableExtra(ToDoEditActivity.KEY_TODO);
            updateTodoList(todo);
        }
    }

    private void setupUI(List<Todo> todos) {
        ListView listView = (ListView) findViewById(R.id.main_list_view);
        adapter = new ToDoListAdpter(this, todos);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_create_todoitem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ToDoEditActivity.class);
                startActivityForResult(intent, ADD_TODO_ITEM);
            }
        });
    }

    private void updateTodoList(Todo todo) {
        boolean found = false;
        for (int i = 0; i < todos.size(); i++) {
            Todo item = todos.get(i);
            if (TextUtils.equals(todo.id, item.id)) {
                todos.get(i).setText(todo.getText());
                found = true;
                break;
            }
        }

        if (!found) {
            todos.add(todo);
        }

        adapter.notifyDataSetChanged();
    }


}
