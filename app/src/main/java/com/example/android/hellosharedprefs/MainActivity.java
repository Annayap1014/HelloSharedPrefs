package com.example.android.hellosharedprefs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.hellosharedprefs.R;

/**
 * Displays two Buttons and a TextView.
 * - Pressing the TOAST button shows a Toast.
 * - Pressing the COUNT button increases the displayed mCount.
 *
 * Note: Fixing behavior when device is rotated is a challenge exercise for the student.
 */

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.android.hellotoast.extra.MESSAGE";

    private int mCount = 0;
    private TextView mShowCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    /*
     * Shows a Toast when the TOAST button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since a toast always shows on the top,
     *             the passed in view is not used.
     */
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, MainActivity2.class);
        String count = Integer.toString(mCount);
        intent.putExtra(EXTRA_MESSAGE, count);
        startActivity(intent);
    }

    /*
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }
}