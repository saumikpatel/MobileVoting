package vote.example.offlinevote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Resetuser extends Activity {
    Button b1;
    Button b2;
    EditText e1;
    EditText e2;
    protected int k;
    private String[] loginArray;
    private String s;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityresetuser);
        this.e1 = (EditText) findViewById(R.id.e1);
        this.e2 = (EditText) findViewById(R.id.e2);
        this.b1 = (Button) findViewById(R.id.b1);
        this.b2 = (Button) findViewById(R.id.b2);
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
            public void onClick(View arg0) {
                int j;
                String lid = Resetuser.this.e1.getText().toString();
                String aid = Resetuser.this.e2.getText().toString();
                String z = "0";
                if (!aid.equals("") && !lid.equals("")) {
                    j = 0;
                    while (j < Resetuser.this.loginArray.length) {
                        if (aid.equals(Resetuser.this.loginArray[j + 2]) && lid.equals(Resetuser.this.loginArray[j + 1])) {
                            Resetuser.this.loginArray[j + 3] = z;
                            Toast.makeText(Resetuser.this.getBaseContext(), "Done!", 1).show();
                            break;
                        }
                        j += 3;
                    }
                } else {
                    Toast.makeText(Resetuser.this.getBaseContext(), "Enter Login-ID and Adhar No.", 1).show();
                }
                try {
                    OutputStreamWriter osw = new OutputStreamWriter(Resetuser.this.openFileOutput("login.txt", 0));
                    for (j = 1; j < Resetuser.this.loginArray.length; j++) {
                        osw.write("," + Resetuser.this.loginArray[j]);
                    }
                    osw.flush();
                    osw.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });
    }
}
