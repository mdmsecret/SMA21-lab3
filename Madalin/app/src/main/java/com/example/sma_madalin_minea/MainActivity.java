package com.example.sma_madalin_minea;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    TextView textView1;
    TextView tName ;
    EditText eName ;
    Button button1, button2, bClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

       /* Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnercol,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        tName = findViewById(R.id.tName);
        eName = findViewById(R.id.eName);
        tName.setText("Hello, " + eName.getText()+"!");

        createPopUp();


    }
    public void onClickBShare(View view){
        String name = ((EditText) findViewById(R.id.eName)).getText().toString();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, name );
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
    public void onClickBSearch(View view){
        String text = ((EditText) findViewById(R.id.eName)).getText().toString();
        String url = "https://www.google.com/search?q="+text;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    @SuppressLint("SetTextI18n")
    public void createPopUp(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View popUp = getLayoutInflater().inflate(R.layout.popupwindow,null);

        textView1 = popUp.findViewById(R.id.textView1);
        textView1.setText("Hello, "+ eName.getText() +"!");

        button1= popUp.findViewById(R.id.button1);
        button2 = popUp.findViewById(R.id.button2);

        dialogBuilder.setView(popUp);
        dialog = dialogBuilder.create();
        dialog.show();
    }
    public void showToast(View v){
        Toast.makeText(this,"1!",Toast.LENGTH_SHORT).show();
    }
    public void showToast2(View v){
        Toast.makeText(this,"2!",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        bClick = findViewById(R.id.bClick);

        switch (text) {
            case "blue":
                bClick.setTextColor(Color.CYAN);

                break;
            case "red":
                bClick.setTextColor(Color.RED);

                break;
            case "yellow":
                bClick.setTextColor(Color.YELLOW);

                break;
            default:
                bClick.setTextColor(Color.BLACK);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}