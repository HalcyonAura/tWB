package cal.worrybook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NoteView extends AppCompatActivity {
    EditText mainText;
    private String fileName;
    NoteHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteview);
        Intent intent = getIntent();
        helper = new NoteHelper();
        fileName = intent.getStringExtra("fileName");
        mainText = (EditText) findViewById(R.id.mainText);
        mainText.setText(helper.Open(fileName, this));
    }
    
    @Override
    public void onBackPressed(){
        helper.Save(fileName, mainText.getText().toString(), this);
        Intent intent = new Intent(this, MainView.class);
        startActivity(intent);
    }
}
