package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Signup extends Activity {
    Button b1;
    EditText e1;
    EditText e2;
    EditText e3;
    private String[] entryArray;
    private String s1;
    private String s2;
    private String s3;
    private String temp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.e1 = (EditText) findViewById(R.id.e1);
        this.e2 = (EditText) findViewById(R.id.e2);
        this.e3 = (EditText) findViewById(R.id.e3);
        this.b1 = (Button) findViewById(R.id.b1);
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
        this.b1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Signup.this.finishActivity(1);
                if (Signup.this.e1.getText().toString().equals("") || Signup.this.e2.getText().toString().equals("") || Signup.this.e3.getText().toString().equals("")) {
                    Toast.makeText(Signup.this.getBaseContext(), "please enter the details", 1).show();
                    return;
                }
                Signup.this.entryArray[1] = Signup.this.e1.getText().toString();
                Signup.this.entryArray[2] = Signup.this.e2.getText().toString();
                Signup.this.entryArray[3] = Signup.this.e3.getText().toString();
                Signup.this.entryArray[4] = "1";
                try {
                    OutputStreamWriter osw = new OutputStreamWriter(Signup.this.openFileOutput("admin.txt", 0));
                    osw.write("," + Signup.this.entryArray[1] + "," + Signup.this.entryArray[2] + "," + Signup.this.entryArray[3] + "," + Signup.this.entryArray[4]);
                    osw.flush();
                    osw.close();
                    Toast.makeText(Signup.this.getBaseContext(), "Signup done", 1).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Signup.this.startActivity(new Intent(Signup.this, Admin.class));
                Signup.this.finish();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.signup, menu);
        return true;
    }
}
