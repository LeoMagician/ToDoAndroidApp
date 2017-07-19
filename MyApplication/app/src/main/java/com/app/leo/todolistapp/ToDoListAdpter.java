package com.app.leo.todolistapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.leo.todolistapp.models.Todo;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Leo on 7/17/17.
 */

public class ToDoListAdpter extends BaseAdapter {
    Context context;
    List<Todo> todos;

    public ToDoListAdpter(@NonNull Context context, List<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public int getCount() {
        return todos.size();
    }

    @Override
    public Object getItem(int pos) {
        return todos.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_list_todo, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.todoText = (TextView) convertView.findViewById(R.id.list_item_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Todo todo = todos.get(pos);
        viewHolder.todoText.setText(todo.getText());

        return convertView;
    }

    private static class ViewHolder {
        TextView todoText;
    }
}
