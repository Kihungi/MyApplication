package com.example.ironlady.myapplication;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActivityPage extends AppCompatActivity {

    Button Save,Load;
    EditText FillData;
    TextView textView;
    String Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        Save = (Button) findViewById(R.id.save);
        Load = (Button) findViewById(R.id.load);
        FillData = (EditText) findViewById(R.id.text);
        textView = (TextView) findViewById(R.id.FUNCTION);
    }


    public void writeMessage(View view) {
        String Message = FillData.getText().toString();
        String file_name= "hello_file";
        try{
            FileOutputStream fileOutputStream = openFileOutput(file_name,MODE_PRIVATE);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Message saved",Toast.LENGTH_LONG).show();
            FillData.getText();

        }catch(FileNotFoundException e){
    e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readMessage(View view){
        try{
        FileInputStream fileInputStream= openFileInput("hello_file");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((Message=bufferedReader.readLine()) !=null){
                stringBuffer.append(Message +"\n");
            }
            textView.setText(stringBuffer.toString());
            textView.setVisibility(View.VISIBLE);

            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}


