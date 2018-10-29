package com.vrinfraprojects.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    public enum Operation{
        ADD,SUBTRACT,DIVIDE,MULTIPLY,EQUAL
    }

    String RunningNumber="";
    TextView result;
    String leftvalue="";
    String rightvalue="";
    Operation currentOperator;
    int finalResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        Button one= (Button) findViewById(R.id.one);
        Button two= (Button) findViewById(R.id.two);
        Button three= (Button) findViewById(R.id.three);
        Button four= (Button) findViewById(R.id.four);
        Button five= (Button) findViewById(R.id.five);
        Button six= (Button) findViewById(R.id.six);
        Button seven= (Button) findViewById(R.id.seven);
        Button eight= (Button) findViewById(R.id.eight);
        Button nine=(Button) findViewById(R.id.nine);
        Button zero=(Button) findViewById(R.id.zero);
        Button clear=(Button) findViewById(R.id.clear);

        ImageButton equal=(ImageButton) findViewById(R.id.equal);
        ImageButton divide=(ImageButton) findViewById(R.id.divide);
        ImageButton mult=(ImageButton) findViewById(R.id.mult);
        ImageButton add=(ImageButton) findViewById(R.id.add);
        ImageButton sub=(ImageButton) findViewById(R.id.sub);

        result=(TextView) findViewById(R.id.result);

        result.setText("");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(9);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberPressed(0);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUBTRACT);
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULTIPLY);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVIDE);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.EQUAL);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftvalue="";
                rightvalue="";
                finalResult=0;
                RunningNumber="";
                currentOperator=null;
                result.setText("0");
            }
        });

    }

    void processOperation(Operation operation){
        if(currentOperator!=null){
            if(RunningNumber!=""){
                rightvalue=RunningNumber;
                RunningNumber="";
                switch(currentOperator){
                    case ADD:
                        finalResult=Integer.parseInt(leftvalue)+Integer.parseInt(rightvalue);
                        break;
                    case SUBTRACT:
                        finalResult=Integer.parseInt(leftvalue)-Integer.parseInt(rightvalue);
                        break;
                    case MULTIPLY:
                        finalResult=Integer.parseInt(leftvalue)*Integer.parseInt(rightvalue);
                        break;
                    case DIVIDE:
                        finalResult=Integer.parseInt(leftvalue)/Integer.parseInt(rightvalue);
                        break;
                }
                leftvalue=String.valueOf(finalResult);
                result.setText(leftvalue);
            }
        }
        else{
            leftvalue=RunningNumber;
            RunningNumber="";
        }
        currentOperator=operation;
    }

    void NumberPressed(int number){
        RunningNumber +=String.valueOf(number);
        result.setText(RunningNumber);

    }
}
