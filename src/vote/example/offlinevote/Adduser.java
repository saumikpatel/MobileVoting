package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Adduser extends Activity {
    Button b1;
    EditText e1;
    EditText e2;
    private String[] loginArray;
    private String s;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        this.e1 = (EditText) findViewById(R.id.e1);
        this.e2 = (EditText) findViewById(R.id.e2);
        this.b1 = (Button) findViewById(R.id.b1);
        try {
            InputStreamReader isr1 = new InputStreamReader(openFileInput("login.txt"));
            char[] inputBuffer1 = new char[100];
            while (true) {
                int charRead1 = isr1.read(inputBuffer1);
                if (charRead1 <= 0) {
                    break;
                }
                this.s += String.copyValueOf(inputBuffer1, 0, charRead1);
                inputBuffer1 = new char[100];
                System.out.print("temp is " + this.s);
            }
            if (this.s != null) {
                this.loginArray = this.s.split(",");
            } else {
                Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String lid = Adduser.this.e1.getText().toString();
                String aid = Adduser.this.e2.getText().toString();
                if (aid.equals("") || lid.equals("")) {
                    Toast.makeText(Adduser.this.getBaseContext(), "Enter Login-ID and Adhar No.", 1).show();
                }
                for (Object equals : Adduser.this.loginArray) {
                    OutputStreamWriter osw;
                    int j;
                    if (aid.equals(equals)) {
                        Toast.makeText(Adduser.this.getBaseContext(), "Adhaar Id already present", 1).show();
                        try {
                            osw = new OutputStreamWriter(Adduser.this.openFileOutput("login.txt", 0));
                            for (j = 1; j < Adduser.this.loginArray.length; j++) {
                                osw.write("," + Adduser.this.loginArray[j]);
                            }
                            osw.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        Adduser.this.e1.setText(" ");
                        Adduser.this.e2.setText(" ");
                        Adduser.this.startActivity(new Intent(Adduser.this, Setting.class));
                        Adduser.this.finish();
                    }
                    try {
                        osw = new OutputStreamWriter(Adduser.this.openFileOutput("login.txt", 0));
                        for (j = 1; j < Adduser.this.loginArray.length; j++) {
                            osw.write("," + Adduser.this.loginArray[j]);
                        }
                        osw.write("," + lid + "," + aid + "," + "0");
                        osw.close();
                    } catch (IOException ioe2) {
                        ioe2.printStackTrace();
                    }
                }
                Adduser.this.e1.setText(" ");
                Adduser.this.e2.setText(" ");
                Adduser.this.startActivity(new Intent(Adduser.this, Setting.class));
                Adduser.this.finish();
            }
        });
    }

    public void onStop() {
        super.onStop();
        finish();
    }
}
