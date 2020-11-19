package me.ogruendel.trianglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab_calc = findViewById(R.id.fab_calc_missing);

        EditText et_side_a = findViewById(R.id.et_side_a);
        EditText et_side_b = findViewById(R.id.et_side_b);
        EditText et_side_c = findViewById(R.id.et_side_c);
        EditText et_angle_alpha = findViewById(R.id.et_angle_alpha);
        EditText et_angle_beta = findViewById(R.id.et_angle_beta);
        EditText et_angle_gamma = findViewById(R.id.et_angle_gamma);

        TextView tv_side_a = findViewById(R.id.tv_side_a);
        TextView tv_side_b = findViewById(R.id.tv_side_b);
        TextView tv_side_c = findViewById(R.id.tv_side_c);
        TextView tv_angle_alpha = findViewById(R.id.tv_angle_alpha);
        TextView tv_angle_beta = findViewById(R.id.tv_angle_beta);
        TextView tv_angle_gamma = findViewById(R.id.tv_angle_gamma);


        fab_calc.setOnClickListener(v -> {
            Triangle t = new Triangle();

            if(!et_side_a.getText().toString().isEmpty()) t.setA(Double.parseDouble(et_side_a.getText().toString()));
            if (!et_side_b.getText().toString().isEmpty()) t.setB(Double.parseDouble(et_side_b.getText().toString()));
            if (!et_side_c.getText().toString().isEmpty()) t.setC(Double.parseDouble(et_side_c.getText().toString()));

            if (!et_angle_alpha.getText().toString().isEmpty()) t.setAlpha(Double.parseDouble(et_angle_alpha.getText().toString()));
            if (!et_angle_beta.getText().toString().isEmpty()) t.setBeta(Double.parseDouble(et_angle_beta.getText().toString()));
            if (!et_angle_gamma.getText().toString().isEmpty()) t.setGamma(Double.parseDouble(et_angle_gamma.getText().toString()));

            t.calcState();

            tv_side_a.setText("Side a: " + round(t.getA(), 2));
            tv_side_b.setText("Side b: " + round(t.getB(), 2));
            tv_side_c.setText("Side c: " + round(t.getC(), 2));

            tv_angle_alpha.setText("Angle α: " + round(t.getAlpha(), 2) + "°");
            tv_angle_beta.setText("Angle β: " + round(t.getBeta(), 2) + "°");
            tv_angle_gamma.setText("Angle γ: " + round(t.getGamma(), 2) + "°");

            Log.d("Side a is: ", String.valueOf(t.getA()));
            Log.d("Side b is: ", String.valueOf(t.getB()));
            Log.d("Side c is: ", String.valueOf(t.getC()));

            Log.d("Angle alpha is: ", String.valueOf(t.getAlpha()));
            Log.d("Angle beta is: ", String.valueOf(t.getBeta()));
            Log.d("Angle gamma is: ", String.valueOf(t.getGamma()));

        });
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}