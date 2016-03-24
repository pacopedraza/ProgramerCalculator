/*
* Alumno: Francisco Javier Pedraza González
* Materia: Matemáticas para Ingenieros
* Profesor: José Zarate
* CIATEQ
* Maestría en Sistemas Inteligentes Multimedia
* Android Application: Convertidor
* */

package com.example.android.programmercalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;

import java.math.BigInteger;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To reset all the information in text boxes, using Clear button
        Button clear = (Button)findViewById(R.id.clearButton);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setMessage("This is a debugger version, in order to perform the functions tap on a field, then type the value and tap again on the text box.  Francisco Pedraza, CIATEQ");
        builder1.setCancelable(true);
        builder1.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();


       // Button convert = (Button)findViewById(R.id.convertButton);

            //Declare all the edit text values
            final EditText decimal = (EditText) findViewById(R.id.decimalTextbox);
            final EditText bin = (EditText) findViewById(R.id.binTextbox);
            final EditText oct = (EditText) findViewById(R.id.octTextBox);
            final EditText b12 = (EditText) findViewById(R.id.B12Textbox);
            final EditText hex = (EditText) findViewById(R.id.HexTextbox);
            final EditText b20 = (EditText) findViewById(R.id.B20Textbox);

        decimal.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View v) {


                         //Toast.makeText(getApplicationContext(),"Got the focus on decimal text box", Toast.LENGTH_LONG).show();
                         String strDecimalValue = decimal.getText().toString();

                         /*Validate if decimal text box is empty and you want to convert something*/

                         if(TextUtils.isEmpty(strDecimalValue))
                         {
                             decimal.setError("You did not enter any value, please try again!");
                             return;
                         }
                                 //Clear all the others edit Text.
                                 bin.setText("");
                                 oct.setText("");
                                 b12.setText("");
                                 hex.setText("");
                                 b20.setText("");

                         int decimalValue;

                         String resultado = ""; //String to store decimal value.
                         decimalValue = Integer.parseInt(decimal.getText().toString());
                         int temp  = decimalValue;

                         Log.d("TAG", "Entered decimal value is " + strDecimalValue);

                         /* C O N V E R T I N G    F R O M   D E C I M A L  T O    B I N A R Y*/
                         while (temp != 0) {
                             if (temp % 2 == 0) {
                                 resultado = "0" + resultado;
                             } else {
                                 resultado = "1" + resultado;
                             }
                             temp = temp / 2;
                         }

                                 String hexVal = ""; //Variable to store the result in hex.
                                 String octVal = ""; //Variable to store the result in oct.
                                 String B12Val = ""; //Variable to store the result in B12.
                                 String B20Val = ""; //Variable to store the result in B20.

                                 int temp2 = decimalValue;
                                 int temp5 = decimalValue;
                                 int temp6 = decimalValue;

                                 /*Vars to be used to calculate the other systems*/
                                 int r;
                                 int rOct;
                                 int rb12;
                                 int rb20;

                 /* C O N V E R T I N G    T O   H E X A D E C I M A L */
                                 //array storing the digits (as characters) in a hexadecimal number system
                                 char dig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                                 while (decimalValue > 0) {
                                     r = decimalValue % 16; //Finding remainder by diving the number by 16
                                     hexVal = dig[r] + hexVal; //Adding the remainder to the result
                                     decimalValue = decimalValue / 16;
                                 }
                    /* C O N V E R T I N G   T O    O C T A L */
                                 char digOct[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
                                 while(temp2 > 0){
                                     rOct = temp2 % 8;
                                     octVal = digOct[rOct] + octVal;
                                     temp2 = temp2 / 8;

                                 }
                /* C O N V E R T I N G   T O    B12 */
                                 //B12Val = Integer.toString(temp3, 12);
                                 char digb12[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'};
                                 while (temp5 > 0) {
                                     rb12 = temp5 % 12; //Finding remainder by diving the number by 12
                                     B12Val = digb12[rb12] + B12Val; //Adding the remainder to the result
                                     temp5 = temp5 / 12;
                                 }

                /* C O N V E R T I N G   T O    B20 */
                                 // B20Val = Integer.toString(temp4, 20);
                                 char digb20[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K'};
                                 while(temp6 > 0){
                                     rb20 = temp6 %20;//Finding remainder by diving the number by 20
                                     B20Val = digb20[rb20] + B20Val; //Adding the remainder to the result
                                     temp6 = temp6 / 20;
                                 }

                         //EditText bin = (EditText) findViewById(R.id.binTextbox);
                         bin.setText(resultado);
                         //EditText hex = (EditText) findViewById(R.id.HexTextbox);
                         hex.setText(hexVal);
                         //EditText oct = (EditText) findViewById(R.id.octTextBox);
                         oct.setText(octVal);
                        // EditText b12 = (EditText) findViewById(R.id.B12Textbox);
                         b12.setText(B12Val);
                         //EditText b20 = (EditText) findViewById(R.id.B20Textbox);
                         b20.setText(B20Val);

                     }

             });

        /* Set bin edit text, and convert from bin to all the bases*/
        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vars to be used

                String StringBinValue = bin.getText().toString();
                if(!StringBinValue.equals("") && (StringBinValue!=null))
                {
                /*  C O N V E R T   F R O M   B I N A R Y   T O  D E C I M A L*/
                    BigInteger bDec = new BigInteger(StringBinValue,2);
                    decimal.setText(bDec.toString(10));

                /*  C O N V E R T   F R O M   B I N A R Y   T O  H E X*/

                    BigInteger bHex = new BigInteger(StringBinValue,2);
                    hex.setText(bHex.toString(16));

                /*  C O N V E R T   F R O M   B I N A R Y   T O   O C T*/
                    BigInteger bOct = new BigInteger(StringBinValue,2);
                    oct.setText(bOct.toString(8));

                /*  C O N V E R T   F R O M   B I N A R Y   T O   B12*/
                    BigInteger big12 = new BigInteger(StringBinValue,2);
                    b12.setText(big12.toString(12));

                /*  C O N V E R T   F R O M   B I N A R Y   T O   B20*/
                    BigInteger big20 = new BigInteger(StringBinValue,2);
                    b20.setText(big20.toString(20));

                }else
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Please enter at least a value on binary text box. Remember that you can only enter values like 0 and 1.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }


            }

        });
         /* Set hex edit text, and convert from bin to all the base*/
        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StringHexValue = hex.getText().toString();
                if(!StringHexValue.equals("") && (StringHexValue!=null))
                {

               /* C O N V E R T   F R O M   H E X   T O   D E C */
               /*
                String digits = "0123456789ABCDEF";
                StringHexValue = StringHexValue.toUpperCase();
                int counter = StringHexValue.length()-1;
                int sum=0;
                for (char c:StringHexValue.toCharArray()) {
                    int i = digits.indexOf(c);
                    sum = (int)(sum + (Math.pow(16,counter))*i);
                    counter --;
                }
                decimal.setText(sum);
                */
               /*convert from hex to bin*/
                    int num = (Integer.parseInt(StringHexValue,16));
                    bin.setText(Integer.toBinaryString(num));
                    String StringBinValue = bin.getText().toString();
                /*  C O N V E R T   F R O M   B I N A R Y   T O  D E C I M A L*/
                /* getting the values from previous result*/
               /* String strBinlValue = bin.getText().toString(); //Now we have bin value -> in string value
                int binValueasInt = Integer.parseInt(bin.getText().toString()); //Bin value now converted to int.
                int decVariable = 0; // Variable to store the converted result
                int binary = binValueasInt;
                int power=0;
                while(binary != 0){
                    int lastDigit = binary % 10;
                    decVariable += lastDigit * Math.pow(2, power);
                    power++;
                    binary = binary / 10;
                }
                decimal.setText(decVariable);*/
                    BigInteger bDec = new BigInteger(StringBinValue,2);
                    decimal.setText(bDec.toString(10));
                    String strDecimalValue = decimal.getText().toString();
                    int decimalValue;
                    String resultado = "";
                    decimalValue = Integer.parseInt(decimal.getText().toString());
                    int temp  = decimalValue;
                /* C O N V E R T I N G    F R O M   D E C I M A L  T O    B I N A R Y*/
                    while (temp != 0) {
                        if (temp % 2 == 0) {
                            resultado = "0" + resultado;
                        } else {
                            resultado = "1" + resultado;
                        }
                        temp = temp / 2;
                    }

                    String octVal = ""; //Variable to store the result in oct.
                    String B12Val = ""; //Variable to store the result in B12.
                    String B20Val = ""; //Variable to store the result in B20.

                    int temp2 = decimalValue;
                    int temp5 = decimalValue;
                    int temp6 = decimalValue;

                                 /*Vars to be used to calculate the other systems*/

                    int rOct;
                    int rb12;
                    int rb20;


                    /* C O N V E R T I N G   T O    O C T A L */
                    char digOct[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
                    while(temp2 > 0){
                        rOct = temp2 % 8;
                        octVal = digOct[rOct] + octVal;
                        temp2 = temp2 / 8;

                    }
                /* C O N V E R T I N G   T O    B12 */
                    //B12Val = Integer.toString(temp3, 12);
                    char digb12[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'};
                    while (temp5 > 0) {
                        rb12 = temp5 % 12; //Finding remainder by diving the number by 12
                        B12Val = digb12[rb12] + B12Val; //Adding the remainder to the result
                        temp5 = temp5 / 12;
                    }

                /* C O N V E R T I N G   T O    B20 */
                    // B20Val = Integer.toString(temp4, 20);
                    char digb20[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K'};
                    while(temp6 > 0){
                        rb20 = temp6 %20;//Finding remainder by diving the number by 20
                        B20Val = digb20[rb20] + B20Val; //Adding the remainder to the result
                        temp6 = temp6 / 20;
                    }

                    oct.setText(octVal);
                    b12.setText(B12Val);
                    b20.setText(B20Val);

                }else
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Please enter at least a value on Hexadecimal text box. Remember that you can only enter values like: 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

        });

        /* Set oct edit text, and convert from bin to all the base*/
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StringOctValue = oct.getText().toString();

                if (!StringOctValue.equals("") && (StringOctValue != null))
                {
                    /*int number = 0;
                    for (int i = 0; i < StringOctValue.length(); i++)
                    {
                        char digit = StringOctValue.charAt(i);
                        digit -= '0';
                        if(digit <0 || digit > 7)
                        {
                            System.out.println("error");
                        }
                        number*= 8;
                        number += digit;
                    }
                    decimal.setText(number);*/
                    int num = (Integer.parseInt(StringOctValue,8));
                    bin.setText(Integer.toBinaryString(num));

                    String StringBinValue = bin.getText().toString();

                    BigInteger bDec = new BigInteger(StringBinValue,2);
                    decimal.setText(bDec.toString(10));
                    int decimalValue;
                    decimalValue = Integer.parseInt(decimal.getText().toString());


                    String hexVal = ""; //Variable to store the result in hex.
                    String B12Val = ""; //Variable to store the result in B12.
                    String B20Val = ""; //Variable to store the result in B20.

                    int temp5 = decimalValue;
                    int temp6 = decimalValue;

                                 /*Vars to be used to calculate the other systems*/
                    int r;
                    int rb12;
                    int rb20;

                 /* C O N V E R T I N G    T O   H E X A D E C I M A L */
                    //array storing the digits (as characters) in a hexadecimal number system
                    char dig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    while (decimalValue > 0) {
                        r = decimalValue % 16; //Finding remainder by diving the number by 16
                        hexVal = dig[r] + hexVal; //Adding the remainder to the result
                        decimalValue = decimalValue / 16;
                    }

                /* C O N V E R T I N G   T O    B12 */
                    //B12Val = Integer.toString(temp3, 12);
                    char digb12[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'};
                    while (temp5 > 0) {
                        rb12 = temp5 % 12; //Finding remainder by diving the number by 12
                        B12Val = digb12[rb12] + B12Val; //Adding the remainder to the result
                        temp5 = temp5 / 12;
                    }

                /* C O N V E R T I N G   T O    B20 */
                    // B20Val = Integer.toString(temp4, 20);
                    char digb20[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K'};
                    while(temp6 > 0){
                        rb20 = temp6 %20;//Finding remainder by diving the number by 20
                        B20Val = digb20[rb20] + B20Val; //Adding the remainder to the result
                        temp6 = temp6 / 20;
                    }

                    hex.setText(hexVal);
                    b12.setText(B12Val);
                    b20.setText(B20Val);



                    //Else of null validation
                } else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Please enter at least a value on Octal text box. Remember that you can only enter values like: 0,1,2,3,4,5,6,7.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }

        });

        /* Set b12 edit text, and convert from bin to all the base*/
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StringB12Value = oct.getText().toString();

                if (!StringB12Value.equals("") && (StringB12Value != null))
                {
                    int num = (Integer.parseInt(StringB12Value,12));
                    bin.setText(Integer.toBinaryString(num));

                    String StringBinValue = bin.getText().toString();

                    BigInteger bDec = new BigInteger(StringBinValue,2);
                    decimal.setText(bDec.toString(10));
                    int decimalValue;
                    decimalValue = Integer.parseInt(decimal.getText().toString());

                    String hexVal = ""; //Variable to store the result in hex.
                    String B20Val = ""; //Variable to store the result in B20.
                    String octVal = ""; //Variable to store the result in oct.


                    int temp6 = decimalValue;
                    int temp2 = decimalValue;

                                 /*Vars to be used to calculate the other systems*/
                    int r;
                    int rb20;
                    int rOct;

                 /* C O N V E R T I N G    T O   H E X A D E C I M A L */
                    //array storing the digits (as characters) in a hexadecimal number system
                    char dig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    while (decimalValue > 0) {
                        r = decimalValue % 16; //Finding remainder by diving the number by 16
                        hexVal = dig[r] + hexVal; //Adding the remainder to the result
                        decimalValue = decimalValue / 16;
                    }
                /* C O N V E R T I N G   T O    O C T A L */
                    char digOct[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
                    while(temp2 > 0){
                        rOct = temp2 % 8;
                        octVal = digOct[rOct] + octVal;
                        temp2 = temp2 / 8;

                    }

                /* C O N V E R T I N G   T O    B20 */
                    // B20Val = Integer.toString(temp4, 20);
                    char digb20[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K'};
                    while(temp6 > 0){
                        rb20 = temp6 %20;//Finding remainder by diving the number by 20
                        B20Val = digb20[rb20] + B20Val; //Adding the remainder to the result
                        temp6 = temp6 / 20;
                    }

                    hex.setText(hexVal);
                    oct.setText(octVal);
                    b20.setText(B20Val);


                }else
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Please enter at least a value on B12 text box. Remember that you can only enter values like: 0,1,2,3,4,5,6,7,8,9,A,B.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }

            }

        });

        /* Set b20 edit text, and convert from bin to all the base*/
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StringB20Value = oct.getText().toString();

                if (!StringB20Value.equals("") && (StringB20Value != null))
                {

                    int num = (Integer.parseInt(StringB20Value,20));
                    bin.setText(Integer.toBinaryString(num));

                    String StringBinValue = bin.getText().toString();

                    BigInteger bDec = new BigInteger(StringBinValue,2);
                    decimal.setText(bDec.toString(10));
                    int decimalValue;
                    decimalValue = Integer.parseInt(decimal.getText().toString());

                    String hexVal = ""; //Variable to store the result in hex.
                    String B20Val = ""; //Variable to store the result in B20.
                    String octVal = ""; //Variable to store the result in oct.
                    String B12Val = ""; //Variable to store the result in B12

                    int temp2 = decimalValue;
                    int temp5 = decimalValue;

                                 /*Vars to be used to calculate the other systems*/
                    int r;
                    int rOct;
                    int rb12;

                 /* C O N V E R T I N G    T O   H E X A D E C I M A L */
                    //array storing the digits (as characters) in a hexadecimal number system
                    char dig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    while (decimalValue > 0) {
                        r = decimalValue % 16; //Finding remainder by diving the number by 16
                        hexVal = dig[r] + hexVal; //Adding the remainder to the result
                        decimalValue = decimalValue / 16;
                    }

                    /* C O N V E R T I N G   T O    B12 */
                    //B12Val = Integer.toString(temp3, 12);
                    char digb12[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B'};
                    while (temp5 > 0) {
                        rb12 = temp5 % 12; //Finding remainder by diving the number by 12
                        B12Val = digb12[rb12] + B12Val; //Adding the remainder to the result
                        temp5 = temp5 / 12;
                    }
                /* C O N V E R T I N G   T O    O C T A L */
                    char digOct[] = {'0', '1', '2', '3', '4', '5', '6', '7'};
                    while(temp2 > 0){
                        rOct = temp2 % 8;
                        octVal = digOct[rOct] + octVal;
                        temp2 = temp2 / 8;

                    }

                    hex.setText(hexVal);
                    oct.setText(octVal);
                    b12.setText(B12Val);



                }else
                {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setMessage("Please enter at least a value on B20 text box. Remember that you can only enter values like: 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }

            }

        });

        //To erase all the content on text boxes
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText decimal = (EditText) findViewById(R.id.decimalTextbox);
                decimal.setText("");

                EditText bin = (EditText) findViewById(R.id.binTextbox);
                bin.setText("");

                EditText oct = (EditText) findViewById(R.id.octTextBox);
                oct.setText("");

                EditText b12 = (EditText) findViewById(R.id.B12Textbox);
                b12.setText("");

                EditText hex = (EditText) findViewById(R.id.HexTextbox);
                hex.setText("");

                EditText b20 = (EditText) findViewById(R.id.B20Textbox);
                b20.setText("");

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
