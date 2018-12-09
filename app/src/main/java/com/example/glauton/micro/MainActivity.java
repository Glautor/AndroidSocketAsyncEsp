//package com.example.glauton.micro;
//
//import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.koushikdutta.async.AsyncServer;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//public class MainActivity extends AppCompatActivity {
//    private static Socket s;
//    private static PrintWriter printWriter;
//    String message = "";
//    private static String ip = "152.238.23.120";
//
//    Button btnFirst, btnSecond, btnThird, btnFourth;
//    EditText editCod;
//    String resultado = null;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btnFirst = (Button) findViewById(R.id.btnFirst);
//        btnSecond = (Button) findViewById(R.id.btnSecond);
//        btnThird = (Button) findViewById(R.id.btnThird);
//        btnFourth = (Button) findViewById(R.id.btnFourth);
//
//        editCod = (EditText) findViewById(R.id.editCod);
//
//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                message = "Teste";
//                SendData sd = new SendData();
//                sd.execute();
//            }
//        });
//    }
//
//
////    public void send_text(View v){
////        message = "Teste";
////
////        MyTask mt = new MyTask();
////        mt.execute();
////
////        Toast.makeText(getApplicationContext(), "Mensagem Enviada", Toast.LENGTH_LONG).show();
////
////    }
//
//
//    class MyTask extends AsyncTask<Void, Void, Void>{
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try{
//                s = new Socket(ip, 1001);
//                printWriter.write(message);
//                printWriter.flush();
//                printWriter.close();
//                s.close();
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
//
//     public class SendData extends AsyncTask<Void, Void, String> {
//         @Override
//         protected String doInBackground(Void... voids) {
//             Socket socket = null;
//             try {
//                 socket = new Socket("127.0.0.1", 1001);
//                 socket.sendUrgentData(1);
//                 socket.getSendBufferSize();
//                 socket.close();
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return socket.toString();
//         }
//     }
//}


// package com.example.glauton.micro;
//
//import android.app.Activity;
//import android.app.IntentService;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.net.ServerSocket;
//import java.net.Socket;

//public class MainActivity extends Activity {
//    static final String TAG = "AndroidCheatSocket";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d(MainActivity.TAG, "onCreate");
//        // We need a `Service` or other background method or else:
//        // http://stackoverflow.com/questions/6343166/android-os-networkonmainthreadexception
//        MainActivity.this.startService(new Intent(MainActivity.this, MyService.class));
//    }
//
//    public static class MyService extends IntentService {
//        public MyService() {
//            super("MyService");
//        }
//        @Override
//        protected void onHandleIntent(Intent intent) {
//            Log.d(MainActivity.TAG, "onHandleIntent");
//            final int port = 1001;
//            ServerSocket listener = null;
//            try {
//                listener = new ServerSocket(port);
//                Log.d(MainActivity.TAG, String.format("listening on port = %d", port));
//                while (true) {
//                    Log.d(MainActivity.TAG, "waiting for client");
//                    Socket socket = listener.accept();
//                    Log.d(MainActivity.TAG, String.format("client connected from: %s", socket.getRemoteSocketAddress().toString()));
//                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                    PrintStream out = new PrintStream(socket.getOutputStream());
//                    for (String inputLine; (inputLine = in.readLine()) != null;) {
//                        Log.d(MainActivity.TAG, "received");
//                        Log.d(MainActivity.TAG, inputLine);
//                        StringBuilder outputStringBuilder = new StringBuilder("");
//                        char inputLineChars[] = inputLine.toCharArray();
//                        for (char c : inputLineChars)
//                            outputStringBuilder.append(Character.toChars(c + 1));
//                        out.println(outputStringBuilder);
//                    }
//                }
//            } catch(IOException e) {
//                Log.d(MainActivity.TAG, e.toString());
//            }
//        }
//    }
//}



//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import java.net.*;
//import java.io.*;
//
//public class MainActivity extends AppCompatActivity {
//    private static Socket s;
//    private static PrintWriter printWriter;
//    String message = "";
//    private static String ip = "152.238.23.120";
//
//    Button btnFirst, btnSecond, btnThird, btnFourth;
//    EditText editCod;
//    String resultado = null;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        btnFirst = (Button) findViewById(R.id.btnFirst);
//        btnSecond = (Button) findViewById(R.id.btnSecond);
//        btnThird = (Button) findViewById(R.id.btnThird);
//        btnFourth = (Button) findViewById(R.id.btnFourth);
//
//        editCod = (EditText) findViewById(R.id.editCod);
//
//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Teste teste = new Teste();
//                teste.execute();
//            }
//        });
//    }
//
//
//    public class Teste extends AsyncTask<Void, Void, Void>{
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            Client client = new Client("127.0.0.1", 1001);
//            return null;
//        }
//    }
//
//    public class Client {
//        // initialize socket and input output streams
//        private Socket socket = null;
//        private DataInputStream input = null;
//        private OutputStream out = null;
//
//        // constructor to put ip address and port
//        public Client(String address, int port) {
//            // establish a connection
//            try {
//                socket = new Socket(address, port);
//                System.out.println("Connected");
//
//                // takes input from terminal
//                input = new DataInputStream(System.in);
//
//                // sends output to the socket
//                out = new DataOutputStream(socket.getOutputStream());
//            } catch (UnknownHostException u) {
//                System.out.println(u);
//            } catch (IOException i) {
//                System.out.println(i);
//            }
//
//            // string to read message from input
//            String line = "";
//
//            // keep reading until "Over" is input
//            while (!line.equals("Over")) {
//                try {
//                    line = input.readLine();
//                    byte[] b = line.getBytes();
//                    out.write(b);
//                } catch (IOException i) {
//                    System.out.println(i);
//                }
//            }
//
//            // close the connection
//            try {
//                input.close();
//                out.close();
//                socket.close();
//            } catch (IOException i) {
//                System.out.println(i);
//            }
//        }
//    }
//}


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
    private static String ip = "127.0.0.1";
    //"152.238.23.120";

    Button btnFirst, btnSecond, btnThird, btnFourth;
    EditText editCod;
    String resultado = null;

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
                message = "Teste";
                Conection conection = new Conection("1");
                conection.onSendMensage();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "Teste";
                Conection conection = new Conection("2");
                conection.onSendMensage();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "Teste";
                Conection conection = new Conection("3");
                conection.onSendMensage();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = "Teste";
                Conection conection = new Conection("4");
                conection.onSendMensage();
            }
        });
    }

}
