package com.example.carlos.tarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class Division extends AppCompatActivity {
    TextView operacion;
    int n1;
    int n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        operacion = (TextView) findViewById(R.id.textView4);

        n1 = GeneradorNumerosAleatorios.generarNumero();
        n2 = GeneradorNumerosAleatorios.generarNumero();

        operacion.setText(n1 + " / " + n2 + " = " + (n1 / n2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_division, menu);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_R){
            Intent intent = new Intent();
            intent.putExtra("result","La división: "+n1+" / "+n2 +" es : "+(n1/n2));
            setResult(RESULT_OK, intent);
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }
}
