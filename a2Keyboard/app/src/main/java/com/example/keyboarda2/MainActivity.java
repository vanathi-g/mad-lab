package com.example.keyboarda2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button btnQ, btnW, btnE, btnR, btnT, btnY, btnU, btnI, btnO, btnP;
    Button btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL;
    Button btnZ, btnX, btnC, btnV, btnB, btnN, btnM;
    Button btnCaps, btnDel, btnNum, btnSpace, btnPeriod, btnComma, btnEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView input = (TextView) findViewById(R.id.input);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                StringBuffer sb= new StringBuffer(str);
                int n = sb.length()-1;
                if(n>0) {
                    sb.deleteCharAt(sb.length() - 1);
                    input.setText(sb);
                }
                else{
                    input.setText("");
                }
            }
        });
        btnQ = (Button) findViewById(R.id.btnQ);
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnQ.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnW = (Button) findViewById(R.id.btnW);
        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnW.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnE = (Button) findViewById(R.id.btnE);
        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnE.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnR = (Button) findViewById(R.id.btnR);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnR.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnT = (Button) findViewById(R.id.btnT);
        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnT.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnY = (Button) findViewById(R.id.btnY);
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnY.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnU = (Button) findViewById(R.id.btnU);
        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnU.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnI = (Button) findViewById(R.id.btnI);
        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnI.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnO = (Button) findViewById(R.id.btnO);
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnO.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnP = (Button) findViewById(R.id.btnP);
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnP.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnA = (Button) findViewById(R.id.btnA);
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnA.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnS = (Button) findViewById(R.id.btnS);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnS.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnD = (Button) findViewById(R.id.btnD);
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnD.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnF = (Button) findViewById(R.id.btnF);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnF.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnG = (Button) findViewById(R.id.btnG);
        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnG.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnH = (Button) findViewById(R.id.btnH);
        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnH.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnJ = (Button) findViewById(R.id.btnJ);
        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnJ.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnK = (Button) findViewById(R.id.btnK);
        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnK.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnL = (Button) findViewById(R.id.btnL);
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnL.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnZ = (Button) findViewById(R.id.btnZ);
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnZ.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnX = (Button) findViewById(R.id.btnX);
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnX.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnC.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnV = (Button) findViewById(R.id.btnV);
        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnV.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnB = (Button) findViewById(R.id.btnB);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnB.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnN = (Button) findViewById(R.id.btnN);
        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnN.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnM = (Button) findViewById(R.id.btnM);
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                String ch = btnM.getText().toString();
                str = str+ch;
                input.setText(str);
            }
        });
        btnComma = (Button) findViewById(R.id.btnComma);
        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                str = str+",";
                input.setText(str);
            }
        });
        btnPeriod = (Button) findViewById(R.id.btnPeriod);
        btnPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                str = str+".";
                input.setText(str);
            }
        });
        btnSpace = (Button) findViewById(R.id.btnSpace);
        btnSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                str = str+" ";
                input.setText(str);
            }
        });
        btnEnter = (Button) findViewById(R.id.btnEnter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                str = str+'\n';
                input.setText(str);
            }
        });
        btnNum = (Button) findViewById(R.id.btnNum);
        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = btnNum.getText().toString();
                if(str.equals("ABC")){
                    btnA.setText("A");
                    btnB.setText("B");
                    btnC.setText("C");
                    btnD.setText("D");
                    btnE.setText("E");
                    btnF.setText("F");
                    btnG.setText("G");
                    btnH.setText("H");
                    btnI.setText("I");
                    btnJ.setText("J");
                    btnK.setText("K");
                    btnL.setText("L");
                    btnM.setText("M");
                    btnN.setText("N");
                    btnO.setText("O");
                    btnP.setText("P");
                    btnQ.setText("Q");
                    btnR.setText("R");
                    btnS.setText("S");
                    btnT.setText("T");
                    btnU.setText("U");
                    btnV.setText("V");
                    btnW.setText("W");
                    btnX.setText("X");
                    btnY.setText("Y");
                    btnZ.setText("Z");
                    btnCaps.setText("⬆");
                    btnNum.setText("123");
                }
                else{
                    btnQ.setText("1");
                    btnW.setText("2");
                    btnE.setText("3");
                    btnR.setText("4");
                    btnT.setText("5");
                    btnY.setText("6");
                    btnU.setText("7");
                    btnI.setText("8");
                    btnO.setText("9");
                    btnP.setText("0");
                    btnA.setText("@");
                    btnS.setText("#");
                    btnD.setText("%");
                    btnF.setText("_");
                    btnG.setText("&");
                    btnH.setText("-");
                    btnJ.setText("+");
                    btnK.setText("(");
                    btnL.setText(")");
                    btnZ.setText("/");
                    btnX.setText("*");
                    btnC.setText("\"");
                    btnV.setText("'");
                    btnB.setText(":");
                    btnN.setText(";");
                    btnM.setText("!");
                    btnCaps.setText("=");
                    btnNum.setText("ABC");
                }
            }
        });
        btnCaps = (Button) findViewById(R.id.btnCaps);
        btnCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = btnCaps.getText().toString();
                if(t.equals("=")){
                    String str = input.getText().toString();
                    str = str+"=";
                    input.setText(str);
                }
                else{
                    String str = btnA.getText().toString();
                    if(str.charAt(0) >= 65 && str.charAt(0) <=90){
                        btnA.setText("a");
                        btnB.setText("b");
                        btnC.setText("c");
                        btnD.setText("d");
                        btnE.setText("e");
                        btnF.setText("f");
                        btnG.setText("g");
                        btnH.setText("h");
                        btnI.setText("i");
                        btnJ.setText("j");
                        btnK.setText("k");
                        btnL.setText("l");
                        btnM.setText("m");
                        btnN.setText("n");
                        btnO.setText("o");
                        btnP.setText("p");
                        btnQ.setText("q");
                        btnR.setText("r");
                        btnS.setText("s");
                        btnT.setText("t");
                        btnU.setText("u");
                        btnV.setText("v");
                        btnW.setText("w");
                        btnX.setText("x");
                        btnY.setText("y");
                        btnZ.setText("z");
                    }
                    else if(str.charAt(0) >= 97 && str.charAt(0) <=122){
                        btnA.setText("A");
                        btnB.setText("B");
                        btnC.setText("C");
                        btnD.setText("D");
                        btnE.setText("E");
                        btnF.setText("F");
                        btnG.setText("G");
                        btnH.setText("H");
                        btnI.setText("I");
                        btnJ.setText("J");
                        btnK.setText("K");
                        btnL.setText("L");
                        btnM.setText("M");
                        btnN.setText("N");
                        btnO.setText("O");
                        btnP.setText("P");
                        btnQ.setText("Q");
                        btnR.setText("R");
                        btnS.setText("S");
                        btnT.setText("T");
                        btnU.setText("U");
                        btnV.setText("V");
                        btnW.setText("W");
                        btnX.setText("X");
                        btnY.setText("Y");
                        btnZ.setText("Z");
                    }
                }
            }
        });
    }
}