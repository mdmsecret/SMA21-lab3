package intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.sma_madalin_minea.R;

public class MainIntentActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);
    }


    public void clickedView1(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.google.com"));
        startActivity(i);

    }
    public void clickedView2(View view) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("tel:00401213456"));
        startActivity(i);

    }
    public void clickedView3(View view) {

        Intent i = new Intent("MSA_LAUNCH");
        i.setData(Uri.parse("http://www.google.com"));
        startActivity(i);

    }
    public void clickedView4(View view) {

        Intent i = new Intent("MSA_LAUNCH");
        i.setData(Uri.parse("tel:00401213456"));
        startActivity(i);

    }

    private class ACTION_MSA_LAUNCH {
    }
}