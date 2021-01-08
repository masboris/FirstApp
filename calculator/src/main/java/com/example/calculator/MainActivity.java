package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b00,b01,b02,b03,b04,b05,b06,b07,b08,b09;
    boolean isFirstDot = true;
    TextView txt, log;
    StringBuffer num = new StringBuffer();
    StringBuffer logString = new StringBuffer();
    Button badd, bsub, bmul, bdiv, bclear, bdot, bequ;
    double v1, v2, result;
    int op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.result);
        log = findViewById(R.id.log);

        b01 = findViewById(R.id.b_1);
        b02 = findViewById(R.id.b_2);
        b03 = findViewById(R.id.b_3);
        b04 = findViewById(R.id.b_4);
        b05 = findViewById(R.id.b_5);
        b06 = findViewById(R.id.b_6);
        b07 = findViewById(R.id.b_7);
        b08 = findViewById(R.id.b_8);
        b09 = findViewById(R.id.b_9);
        b00 = findViewById(R.id.b_0);
        badd = findViewById(R.id.b_add);
        bsub = findViewById(R.id.b_sub);
        bmul = findViewById(R.id.b_mul);
        bdiv = findViewById(R.id.b_div);
        bdot = findViewById(R.id.b_dot);
        bequ = findViewById(R.id.b_equal);
        bclear = findViewById(R.id.b_clear);


        NumClick nc = new NumClick();
        b00.setOnClickListener(nc);
        b01.setOnClickListener(nc);
        b02.setOnClickListener(nc);
        b03.setOnClickListener(nc);
        b04.setOnClickListener(nc);
        b05.setOnClickListener(nc);
        b06.setOnClickListener(nc);
        b07.setOnClickListener(nc);
        b08.setOnClickListener(nc);
        b09.setOnClickListener(nc);

        bclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFirstDot = true;
                num.delete(0,num.length());
                txt.setText("0.0");
                logString.delete(0,logString.length());
                log.setText("");
                v1 = 0.0;
                v2 = 0.0;
                result = 0.0;
            }
        });

        OpClick oc = new OpClick();
        badd.setOnClickListener(oc);
        bsub.setOnClickListener(oc);
        bequ.setOnClickListener(oc);
        bmul.setOnClickListener(oc);
        bdiv.setOnClickListener(oc);

        bdot.setOnClickListener(nc);


    }

    class OpClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            isFirstDot = true;
            switch (view.getId()){
                case R.id.b_add:
                    System.out.println("op" + op);
                    txt.setText("");
                    if (num.length() == 0) {
                    }
                    else {

                            if (v1 == 0.0) {
                                v1 = Double.parseDouble(num.toString());
                            }
                            else {
                                v2 = Double.parseDouble(num.toString());
                                switch (op) {
                                    case 1:
                                        result = v1 + v2;
                                        break;
                                    case 2:
                                        result = v1 - v2;
                                        break;
                                    case 3:
                                        result = v1 / v2;
                                        break;
                                    case 4:
                                        result = v1 * v2;
                                        break;
                                }
//                                result = v1 + v2;
                                txt.setText("= " + result);
                                logString.delete(0,logString.length());
                                logString.append(Double.toString(result));
                                v1 = result;
                                v2 = 0.0;
                            }


                        num.delete(0,num.length());
                        logString.append(" + ");
                        log.setText(logString.toString());
                    }

                    op = 1;
                    break;

                case  R.id.b_sub:
                    txt.setText("");
                    if (num.length() == 0) {
                        break;
                    }
                    else {
                        if (v1 == 0.0) {
                            v1 = Double.parseDouble(num.toString());
                        }
                        else {
                            v2 = Double.parseDouble(num.toString());
                            switch (op) {
                                case 1:
                                    result = v1 + v2;
                                    break;
                                case 2:
                                    result = v1 - v2;
                                    break;
                                case 3:
                                    result = v1 / v2;
                                    break;
                                case 4:
                                    result = v1 * v2;
                                    break;
                            }
                            txt.setText("= " + result);
                            v1 = result;
                            v2 = 0.0;
                            logString.delete(0,logString.length());
                            logString.append(Double.toString(result));
                        }

                        logString.append(" - ");
                        log.setText(logString.toString());
                        op = 2;
                        num.delete(0, num.length());
                        break;
                    }
                case  R.id.b_div:
                    txt.setText("");

                    if (num.length() == 0) {
                        break;
                    }
                    else {
                        if (v1 == 0.0) {
                            v1 = Double.parseDouble(num.toString());
                        }
                        else {
                            v2 = Double.parseDouble(num.toString());
                            switch (op) {
                                case 1:
                                    result = v1 + v2;
                                    break;
                                case 2:
                                    result = v1 - v2;
                                    break;
                                case 3:
                                    result = v1 / v2;
                                    break;
                                case 4:
                                    result = v1 * v2;
                                    break;
                            }
                            txt.setText("= " + result);
                            v1 = result;
                            v2 = 0.0;
                            logString.delete(0,logString.length());
                            logString.append(Double.toString(result));

                        }

                        logString.append(" / ");
                        log.setText(logString.toString());
                        op = 3;
                        num.delete(0, num.length());
                        break;
                    }
                case  R.id.b_mul:
                    txt.setText("");
                    if (num.length() == 0) {
                        break;
                    }
                    else {
                        if (v1 == 0.0) {
                            v1 = Double.parseDouble(num.toString());
                        }
                        else {
                            v2 = Double.parseDouble(num.toString());
                            switch (op) {
                                case 1:
                                    result = v1 + v2;
                                    break;
                                case 2:
                                    result = v1 - v2;
                                    break;
                                case 3:
                                    result = v1 / v2;
                                    break;
                                case 4:
                                    result = v1 * v2;
                                    break;
                            }
                            txt.setText("= " + result);
                            v1 = result;
                            v2 = 0.0;
                            logString.delete(0,logString.length());
                            logString.append(Double.toString(result));

                        }

                        logString.append(" * ");
                        log.setText(logString.toString());
                        op = 4;
                        num.delete(0, num.length());
                        break;
                    }

                case R.id.b_equal:

                    if (num.length() == 0) {
                        break;
                    }
                    else {
                        v2 = Double.parseDouble(num.toString());
                        switch (op) {
                            case 1:
                                result = v1 + v2;
                                txt.setText("= " + result);
                                num.delete(0, num.length());
                                num.append(Double.toString(result));
                                v1 = 0.0;
                                break;
                            case 2:
                                result = v1 - v2;
                                txt.setText("= " + result);
                                num.delete(0, num.length());
                                num.append(Double.toString(result));
                                v1 = 0.0;
                                break;
                            case 3:
                                result = v1 / v2;
                                txt.setText("= " + result);
                                num.delete(0, num.length());
                                num.append(Double.toString(result));
                                v1 = 0.0;
                                break;
                            case 4:
                                result = v1 * v2;
                                txt.setText("= " + result);
                                num.delete(0, num.length());
                                num.append(Double.toString(result));
                                v1 = 0.0;
                                break;

                            default:
                                num.delete(0, num.length());
                                break;
                        }
                        logString.delete(0,logString.length());
                        logString.append(Double.toString(result));
                        break;
                    }


            }
        }
    }

    class NumClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
//            Log.e("which:", ""+view.getId());

            switch (view.getId()){
                case R.id.b_0:
                case R.id.b_1:
                case R.id.b_2:
                case R.id.b_3:
                case R.id.b_4:
                case R.id.b_5:
                case R.id.b_6:
                case R.id.b_7:
                case R.id.b_8:
                case R.id.b_9:
                    Button number = (Button) view;
                    num.append(number.getText());
                    logString.append(number.getText());
                    log.setText(logString.toString());
                    txt.setText("");
//                    txt.setText(Double.toString(result));
                    break;
                case R.id.b_dot:
                    if (isFirstDot) {
                        Button bdot = (Button) view;
                        num.append(bdot.getText());
//                        txt.setText(num.toString());
                        logString.append(bdot.getText());
                        log.setText(logString.toString());
                        isFirstDot= false;
                        break;
                    }



            }



        }
    }
}
