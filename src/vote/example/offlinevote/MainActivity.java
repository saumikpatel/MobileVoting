package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {
  

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
         this.bt1 = (Button) findViewById(R.id.b1);
        this.bt2 = (Button) findViewById(R.id.b2);
        this.e1 = (EditText) findViewById(R.id.et1);
        this.e2 = (EditText) findViewById(R.id.et2);
        try {
            if (!getBaseContext().getFileStreamPath("admin.txt").exists()) {
                OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("admin.txt", 0));
                osw.write(",adgjl,zcbm,hyu,0");
                osw.flush();
                osw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (!getBaseContext().getFileStreamPath("login.txt").exists()) {
                osw = new OutputStreamWriter(openFileOutput("login.txt", 0));
                osw.write(",a,123,0,b,234,0,c,345,0");
                osw.flush();
                osw.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            InputStreamReader isr = new InputStreamReader(openFileInput("login.txt"));
            char[] inputBuffer = new char[100];
            while (true) {
                int charRead = isr.read(inputBuffer);
                if (charRead <= 0) {
                    break;
                }
                this.temp += String.copyValueOf(inputBuffer, 0, charRead);
                inputBuffer = new char[100];
                System.out.print("temp is " + this.temp);
            }
            if (this.temp != null) {
                this.entryArray = this.temp.split(",");
            } else {
                Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
            }
        } catch (IOException e22) {
            e22.printStackTrace();
        }
        try {
            if (!getBaseContext().getFileStreamPath("vote.txt").exists()) {
                osw = new OutputStreamWriter(openFileOutput("vote.txt", 0));
                for (int i = 0; i < 100; i++) {
                    osw.write(",0");
                }
                osw.flush();
                osw.close();
            }
        } catch (IOException e222) {
            e222.printStackTrace();
        }
        try {
            if (!getBaseContext().getFileStreamPath("input.txt").exists()) {
                osw = new OutputStreamWriter(openFileOutput("input.txt", 0));
                osw.write("4");
                osw.flush();
                osw.close();
            }
        } catch (IOException e2222) {
            e2222.printStackTrace();
        }
        try {
            if (!getBaseContext().getFileStreamPath("party.txt").exists()) {
                osw = new OutputStreamWriter(openFileOutput("party.txt", 0));
                osw.write(",A,B,C,D");
                osw.flush();
                osw.close();
            }
        } catch (IOException e22222) {
            e22222.printStackTrace();
        }
        this.bt2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Admin.class));
            }
        });
        this.bt1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                String login = MainActivity.this.e1.getText().toString();
                String adhar = MainActivity.this.e2.getText().toString();
                if (login.equals("") || adhar.equals("")) {
                    Toast.makeText(MainActivity.this.getBaseContext(), "Enter Login-ID and Adhar No.", 1).show();
                    return;
                }
                int i = 1;
                while (i < MainActivity.this.entryArray.length) {
                    if (!adhar.equals(MainActivity.this.entryArray[i + 1]) || !login.equals(MainActivity.this.entryArray[i])) {
                        if (i == MainActivity.this.entryArray.length - 3) {
                            Toast.makeText(MainActivity.this.getBaseContext(), "You are not a valid User", 1).show();
                        }
                        i += 3;
                    } else if (MainActivity.this.entryArray[i + 2].equals("0")) {
                        Bundle b = new Bundle();
                        b.putString("login", login);
                        b.putString("adhar", adhar);
                        Intent in = new Intent(MainActivity.this, Vote.class);
                        in.putExtras(b);
                        MainActivity.this.startActivity(in);
                        MainActivity.this.finish();
                        return;
                    } else {
                        Toast.makeText(MainActivity.this.getBaseContext(), "You have already VOTED", 1).show();
                        MainActivity.this.e1.setText("");
                        MainActivity.this.e2.setText("");
                        return;
                    }
                }
            }
        });
        
       
        
        
       
    }

   

   
}
