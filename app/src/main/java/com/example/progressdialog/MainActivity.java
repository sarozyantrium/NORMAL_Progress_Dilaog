package com.example.progressdialog;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click=(Button) findViewById(R.id.btn_click);

    }

    public void open_progress_dialog(View view)
    {
        ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("PROGRESS DIALOG");
        progressDialog.setMessage("This is normal progress Dialog");
        progressDialog.setIcon(R.drawable.circle);
        progressDialog.setCancelable(false);
        progressDialog.show();

        //tO SET time duration

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(5000);
                    //this is to set after 5 second it must be dismiss
                    progressDialog.dismiss();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });thread.start();

    }
}