package me.ogruendel.trianglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab_calc = findViewById(R.id.fab_calc_missing);

        EditText et_angle_alpha = findViewById(R.id.et_angle_alpha);
        EditText et_angle_beta = findViewById(R.id.et_angle_beta);
        EditText et_angle_gamma = findViewById(R.id.et_angle_gamma);
        EditText et_side_a = findViewById(R.id.et_side_a);
        EditText et_side_b = findViewById(R.id.et_side_b);
        EditText et_side_c = findViewById(R.id.et_side_c);


        fab_calc.setOnClickListener(v -> {
            Triangle t = new Triangle();

            if(!et_side_a.getText().toString().isEmpty()) t.setA(Double.parseDouble(et_side_a.getText().toString()));
            if (!et_side_b.getText().toString().isEmpty()) t.setB(Double.parseDouble(et_side_b.getText().toString()));
            if (!et_side_c.getText().toString().isEmpty()) t.setC(Double.parseDouble(et_side_c.getText().toString()));

            if (!et_angle_alpha.getText().toString().isEmpty()) t.setAlpha(Double.parseDouble(et_angle_alpha.getText().toString()));
            if (!et_angle_beta.getText().toString().isEmpty()) t.setBeta(Double.parseDouble(et_angle_beta.getText().toString()));
            if (!et_angle_gamma.getText().toString().isEmpty()) t.setGamma(Double.parseDouble(et_angle_gamma.getText().toString()));

            t.calcState();

            Log.d("Side a is: ", String.valueOf(t.getA()));
            Log.d("Side b is: ", String.valueOf(t.getB()));
            Log.d("Side c is: ", String.valueOf(t.getC()));

            Log.d("Angle alpha is: ", String.valueOf(t.getAlpha()));
            Log.d("Angle beta is: ", String.valueOf(t.getBeta()));
            Log.d("Angle gamma is: ", String.valueOf(t.getGamma()));

        });
    }
}