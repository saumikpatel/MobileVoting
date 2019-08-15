package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin extends Activity {
    Button b3;
    Button b5;
    String[] entryArray;
    EditText et3;
    EditText et4;
    TextView t1;
    String tag = "Events";
    String temp;
    private String temps;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        this.et3 = (EditText) findViewById(R.id.et3);
        this.et4 = (EditText) findViewById(R.id.et4);
        this.b3 = (Button) findViewById(R.id.b3);
        this.t1 = (TextView) findViewById(R.id.t1);
        this.b5 = (Button) findViewById(R.id.b5);
        try {
            InputStreamReader isr = new InputStreamReader(openFileInput("admin.txt"));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.b3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String s1 = Admin.this.et3.getText().toString();
                String s2 = Admin.this.et4.getText().toString();
                if (s1.equals("") && s2.equals("")) {
                    Toast.makeText(Admin.this.getBaseContext(), "enter the Details", 1).show();
                } else if (s1.equals(Admin.this.entryArray[1]) && s2.equals(Admin.this.entryArray[2])) {
                    Toast.makeText(Admin.this.getBaseContext(), "welcome Admin", 1).show();
                    Admin.this.startActivity(new Intent(Admin.this, Count.class));
                    Admin.this.et3.setText("");
                    Admin.this.et4.setText("");
                } else {
                    Toast.makeText(Admin.this.getBaseContext(), "Invalid Details", 1).show();
                }
            }
        });
        this.b5.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                if (Admin.this.entryArray[4].equals("0")) {
                    Admin.this.startActivity(new Intent(Admin.this, Signup.class));
                    Admin.this.finish();
                    return;
                }
                Toast.makeText(Admin.this.getBaseContext(), "you have already created account", 1).show();
            }
        });
        this.t1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Admin.this.startActivity(new Intent(Admin.this, ResetPassword.class));
                Admin.this.finish();
            }
        });
    }

    public void onRestart() {
        super.onRestart();
        try {
            InputStreamReader isr = new InputStreamReader(openFileInput("admin.txt"));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
