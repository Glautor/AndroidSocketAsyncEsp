package com.example.glauton.micro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private static Socket s;
    private static PrintWriter printWriter;
    String message = "";
    private static String hostName = "192.168.4.1";
    private static int port = 555;

    Button btnFirst, btnSecond, btnThird, btnFourth;
    EditText editCod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFirst = (Button) findViewById(R.id.btnFirst);
        btnSecond = (Button) findViewById(R.id.btnSecond);
        btnThird = (Button) findViewById(R.id.btnThird);
        btnFourth = (Button) findViewById(R.id.btnFourth);
        editCod = (EditText) findViewById(R.id.editCod);
        sendMessage();
    }

    public void sendMessage(){
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = new Connection("1", hostName, port);
                connection.onSendMensage();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = new Connection("2", hostName, port);
                connection.onSendMensage();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = new Connection("3", hostName, port);
                connection.onSendMensage();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = new Connection("4", hostName, port);
                connection.onSendMensage();
            }
        });
    }

}
