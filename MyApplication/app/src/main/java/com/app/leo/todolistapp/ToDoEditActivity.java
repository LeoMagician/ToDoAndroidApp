package com.app.leo.todolistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.app.leo.todolistapp.models.Todo;

/**
 * Created by Leo on 7/18/17.
 */

public class ToDoEditActivity extends AppCompatActivity {

    public static final String KEY_TODO = "todo_item";
    private Todo todo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        todo = getIntent().getParcelableExtra(KEY_TODO);
        setUpSaveButton();
//        setUpToDoDetailUI();
    }

    private void setUpSaveButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.todo_detail_done);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveAndExit();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void saveAndExit() {
        if (todo == null) {
            todo = new Todo();
        }

        String text = ((EditText)findViewById(R.id.todo_detail_edit)).getText().toString();
        todo.setText(text);

        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_TODO, todo);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private void setUpToDoDetailUI() {

    }

}
