package com.mruraza.calculatooor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     TextView resultt,procedure;
     Button btn0,btn01,btn02,btn03,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
     Button btn12,btn13,btn14,btn15,btn16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        procedure = findViewById(R.id.procedure);
        resultt = findViewById(R.id.resultt);
//        btn03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//
//            }
//        });
//        initialize();re
        assignId(btn0,R.id.btn0);
        assignId(btn01,R.id.btn01);
        assignId(btn02,R.id.btn02);
        assignId(btn03,R.id.btn03);
        assignId(btn1,R.id.btn1);
        assignId(btn2,R.id.btn2);
        assignId(btn3,R.id.btn3);
        assignId(btn4,R.id.btn4);
        assignId(btn5,R.id.btn5);
        assignId(btn6,R.id.btn6);
        assignId(btn7,R.id.btn7);
        assignId(btn8,R.id.btn8);
        assignId(btn9,R.id.btn9);
        assignId(btn10,R.id.btn10);
        assignId(btn11,R.id.btn11);
        assignId(btn12,R.id.btn12);
        assignId(btn13,R.id.btn13);
        assignId(btn14,R.id.btn14);
        assignId(btn15,R.id.btn15);
        assignId(btn16,R.id.btn16);




    }
    void assignId(Button bttn, int id)
    {
         bttn = findViewById(id);
         bttn.setOnClickListener(this);

    }

//    private void initialize()
//    {
//        resultt = findViewById(R.id.resultt);
//        procedure = findViewById(R.id.procedure);
//        btn0 = findViewById(R.id.btn0);
//        btn01= findViewById(R.id.btn01);
//        btn02= findViewById(R.id.btn02);
//        btn03= findViewById(R.id.btn03);
//        btn1=findViewById(R.id.btn1);
//        btn2=findViewById(R.id.btn2);
//        btn3=findViewById(R.id.btn3);
//        btn4=findViewById(R.id.btn4);
//        btn5=findViewById(R.id.btn5);
//        btn6=findViewById(R.id.btn6);
//        btn7=findViewById(R.id.btn7);
//        btn8 = findViewById(R.id.btn8);
//        btn9= findViewById(R.id.btn9);
//        btn10 = findViewById(R.id.btn10);
//        btn11 = findViewById(R.id.btn11);
//        btn12 = findViewById(R.id.btn12);
//        btn13 = findViewById(R.id.btn13);
//        btn14 = findViewById(R.id.btn14);
//        btn15 = findViewById(R.id.btn15);
//        btn16 = findViewById(R.id.btn16);
//
//    }

    @Override
    public void onClick(View view)
    {
      Button crntbtn = (Button) view;
      String buttontext = crntbtn.getText().toString();
//      procedure.setText(buttontext);
        String datatocalculate = procedure.getText().toString();


        if(buttontext.equals("AC"))
        {
            procedure.setText("");
            resultt.setText("0");
            return;
        }
        if(buttontext.equals("="))
        {

            procedure.setText(resultt.getText());
            return;
        }
        if(buttontext.equals("C"))
        {
            datatocalculate=datatocalculate.substring(0,datatocalculate.length()-1);
        }else {
            datatocalculate+=buttontext;
        }
        procedure.setText(datatocalculate);
        String finaresult = getresult(datatocalculate);

        if(!finaresult.equals("Error"))
        {
            resultt.setText(finaresult);
        }


    }
    String getresult(String data)
    {
         try {

                 Context context = Context.enter();
                 context.setOptimizationLevel(-1);
                 Scriptable scriptable = context.initStandardObjects();
                 String finalans = context.evaluateString(scriptable,data,"javascript",1,null).toString();
                 return finalans;
             }
             catch (Exception e)
             {
                 return "Error";
             }
         }
    }
