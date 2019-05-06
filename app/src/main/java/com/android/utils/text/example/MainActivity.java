package com.android.utils.text.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.utils.text.table.LogTable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printTable(View view) {
        LogTable logTable = new LogTable();
        logTable.headers("A", "B", "C", "D", "E");
        logTable.rows("1", "2", "3", "4.3879146986541").end()
                .rows("1", "2.89132748", "3.43124", "4.3879146986541").end()
                .rows("1", "2", "3.84207187").end()
                .rows("1.1", "2", "3", "4.3879146986541").end();
        logTable.log();
    }
}
