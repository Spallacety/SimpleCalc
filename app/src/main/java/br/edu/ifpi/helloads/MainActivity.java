package br.edu.ifpi.helloads;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void hideKeyboard(Context context, View editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void enviarClick(View v){
        double resultado;
        String expressao = null;

        EditText editNum1 = (EditText)findViewById(R.id.num1);
        EditText editNum2 = (EditText)findViewById(R.id.num2);

        double num1 = Double.valueOf(editNum1.getText().toString());
        double num2 = Double.valueOf(editNum2.getText().toString());

        RadioGroup rg = (RadioGroup)findViewById(R.id.op);

        editNum1.setText(null);
        editNum2.setText(null);

        switch (rg.getCheckedRadioButtonId()){
            case (R.id.soma):
                resultado = num1 + num2;
                expressao = num1 + " + " + num2;
                break;
            case (R.id.sub):
                resultado = num1 - num2;
                expressao = num1 + " - " + num2;
                break;
            case (R.id.mult):
                resultado = num1 * num2;
                expressao = num1 + " * " + num2;
                break;
            case (R.id.div):
                resultado = num1 / num2;
                expressao = num1 + " / " + num2;
                break;
            default:
                resultado = 0;
        }

        TextView textView = (TextView)findViewById(R.id.res);
        LinearLayout ll = (LinearLayout)findViewById(R.id.tela1);
        if(textView.getText()!=null){
            ll.removeView(textView);
        }
        textView.setText(expressao + " = " + resultado);
        ll.addView(textView);
        hideKeyboard(this, textView);

    }
}
