package com.android.tp1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("INFO", "Activity Created!");

        if(this.getIntent().getExtras() != null){
            String s = this.getIntent().getExtras().getString("madonne");
            EditText edit= this.findViewById(R.id.edit);
            edit.setText(s);
        }

        Button button= this.findViewById(R.id.button);
        button.setOnClickListener(this::myClick);

        Button button2= this.findViewById(R.id.button2);
        button2.setOnClickListener(this::myClick2);

        Button button3= this.findViewById(R.id.button3);
        button3.setOnClickListener(this::myClick3);

        Button button4= this.findViewById(R.id.button4);
        button4.setOnClickListener(this::myClick4);

        Intent data = new Intent();
        data.putExtra("Val", "Bonjour");
        this.setResult(2000, data);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            if(resultCode==2000){
                EditText edit= this.findViewById(R.id.edit);
                if (data != null) {
                    edit.setText(Objects.requireNonNull(data.getExtras()).getString("Val"));
                }
            }
        }
    }

    private void myClick(View v) {
        EditText edit= this.findViewById(R.id.edit);
        edit.setText("You Clicked!");
    }

    private void myClick2(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("madonne", "Hi");
        this.startActivity(intent);
    }

    private void myClick3(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("madonne", "Third Button");
        this.startActivityForResult(intent, 100);
    }

    private void myClick4(View v) {
        Intent intent = new Intent(this, ItemListActivity.class);
        intent.putExtra("madonne", "Fourth Button");
        this.startActivity(intent);;
    }
}