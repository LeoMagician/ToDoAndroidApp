package com.app.leo.todolistapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

/**
 * Created by Leo on 7/17/17.
 */

public class Todo implements Parcelable {
    private String text;
    public String id;

    public Todo() {
        this.id = UUID.randomUUID().toString();
    }

    protected Todo(Parcel in) {
        text = in.readString();
        id = in.readString();
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeString(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
