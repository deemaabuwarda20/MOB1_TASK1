package com.example.hellotoast;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView showCount;
    private Button buttonCount;
    private Button buttonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showCount = findViewById(R.id.show_count);
        buttonCount = findViewById(R.id.button_count);
        buttonZero = findViewById(R.id.button_zero);
    }
    public void showCount(View view) {

        mCount++;
        showCount.setText(String.valueOf(mCount));

        if (mCount % 2 == 0) {
            buttonCount.setBackgroundColor(Color.BLUE);
        } else {
            buttonCount.setBackgroundColor(Color.GREEN);
        }

        buttonZero.setBackgroundColor(Color.MAGENTA);
    }

    public void showZero(View view) {

        mCount = 0;
        showCount.setText("0");

        buttonZero.setBackgroundColor(Color.GRAY);
    }
}