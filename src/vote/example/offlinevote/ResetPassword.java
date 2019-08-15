package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ResetPassword extends Activity {
    Button b1;
    Button b2;
    EditText e;
    EditText e1;
    String[] entryArray;
    private int id;
    LinearLayout l1;
    private String s1;
    String temp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        this.e1 = (EditText) findViewById(R.id.e1);
        this.e = (EditText) findViewById(R.id.e);
        this.b1 = (Button) findViewById(R.id.b1);
        this.l1 = (LinearLayout) findViewById(R.id.l1);
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
                if (ResetPassword.this.e1.getText().toString().equals("") || ResetPassword.this.e.getText().toString().equals("")) {
                    Toast.makeText(ResetPassword.this.getBaseContext(), "Enter the details properly", 1).show();
                } else if (ResetPassword.this.e1.getText().toString().equals(ResetPassword.this.entryArray[3])) {
                    ResetPassword.this.entryArray[2] = ResetPassword.this.e.getText().toString();
                    try {
                        OutputStreamWriter osw = new OutputStreamWriter(ResetPassword.this.openFileOutput("admin.txt", 0));
                        osw.write("," + ResetPassword.this.entryArray[1] + "," + ResetPassword.this.entryArray[2] + "," + ResetPassword.this.entryArray[3] + "," + ResetPassword.this.entryArray[4]);
                        osw.flush();
                        osw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(ResetPassword.this.getBaseContext(), "Done", 1).show();
                    ResetPassword.this.startActivity(new Intent(ResetPassword.this, Admin.class));
                    ResetPassword.this.finish();
                } else {
                    Toast.makeText(ResetPassword.this.getBaseContext(), "  sorry Details not matched", 1).show();
                }
            }
        });
    }

    public void onStop() {
        super.onStop();
        finish();
    }
}
