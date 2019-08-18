package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Count extends Activity {
    Button b22;
    Button b23;
    Button b24;
    Button back;
    String[] entryArray;
    protected int j;
    LinearLayout l1;
    private String n;
    private String n1;
    private String p;
    private String p1;
    private String[] partyArray;
    Button reset;
    protected String str;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    private String temp;
    private String tempp;
    private int z;

    protected void onCreate(Bundle savedInstanceState) {
        InputStreamReader isr;
        char[] inputBuffer;
        int charRead;
        TextView[] tt;
        int i;
        Button b;
        int k;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);
        this.l1 = (LinearLayout) findViewById(R.id.l1);
        try {
            if (getBaseContext().getFileStreamPath("input.txt").exists()) {
                BufferedReader isr2 = new BufferedReader(new InputStreamReader(openFileInput("input.txt")));
                while (true) {
                    String readLine = isr2.readLine();
                    this.temp = readLine;
                    if (readLine != null) {
                        this.n = this.temp;
                    }
                }
                isr = new InputStreamReader(openFileInput("party.txt"));
                inputBuffer = new char[100];
                while (true) {
                    charRead = isr.read(inputBuffer);
                    if (charRead <= 0) {
                        break;
                    }
                    this.p += String.copyValueOf(inputBuffer, 0, charRead);
                    inputBuffer = new char[100];
                    System.out.print("temp is " + this.p);
                }
                if (this.p == null) {
                    this.partyArray = this.p.split(",");
                } else {
                    Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
                }
                isr = new InputStreamReader(openFileInput("vote.txt"));
                inputBuffer = new char[100];
                while (true) {
                    charRead = isr.read(inputBuffer);
                    if (charRead <= 0) {
                        break;
                    }
                    this.temp += String.copyValueOf(inputBuffer, 0, charRead);
                    inputBuffer = new char[100];
                    System.out.print("temp is " + this.temp);
                }
                if (this.temp == null) {
                    this.entryArray = this.temp.split(",");
                } else {
                    Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
                }
				this.z = Integer.parseInt(this.n);
                tt = new TextView[this.z];
                for (i = 0; i < this.z; i++) {
                    tt[i] = new TextView(this);
                    tt[i].setId(i);
                    tt[i].setText(new StringBuilder(String.valueOf(this.entryArray[i + 1])).append("      ").append(this.partyArray[i + 1]).toString());
                    tt[i].setPadding(30, 30, 30, 30);
                    this.l1.addView(tt[i]);
                }
                b = new Button(this);
                b.setText("Settings");
                b.setId(5);
                this.l1.addView(b);
                k = b.getId();
                b.setOnClickListener(new OnClickListener() {
                    public void onClick(View arg0) {
                        Count.this.startActivity(new Intent(Count.this, Setting.class));
                    }
                });
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            isr = new InputStreamReader(openFileInput("party.txt"));
            inputBuffer = new char[100];
            while (true) {
                charRead = isr.read(inputBuffer);
                if (charRead <= 0) {
                    break;
                }
                this.p += String.copyValueOf(inputBuffer, 0, charRead);
                inputBuffer = new char[100];
                System.out.print("temp is " + this.p);
            }
            if (this.p == null) {
                Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
            } else {
                this.partyArray = this.p.split(",");
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            isr = new InputStreamReader(openFileInput("vote.txt"));
            inputBuffer = new char[100];
            while (true) {
                charRead = isr.read(inputBuffer);
                if (charRead <= 0) {
                    break;
                }
                this.temp += String.copyValueOf(inputBuffer, 0, charRead);
                inputBuffer = new char[100];
                System.out.print("temp is " + this.temp);
            }
            if (this.temp == null) {
                Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
            } else {
                this.entryArray = this.temp.split(",");
            }
        } catch (IOException e22) {
            e22.printStackTrace();
        }
        this.z = Integer.parseInt(this.n);
        tt = new TextView[this.z];
        for (i = 0; i < this.z; i++) {
            tt[i] = new TextView(this);
            tt[i].setId(i);
            tt[i].setText(new StringBuilder(String.valueOf(this.entryArray[i + 1])).append("      ").append(this.partyArray[i + 1]).toString());
            tt[i].setPadding(30, 30,30, 30);
            this.l1.addView(tt[i]);
        }
        b = new Button(this);
        b.setText("Settings");
        b.setId(5);
        this.l1.addView(b);
        k = b.getId();
        b.setOnClickListener(/* anonymous class already generated */);
    }
}
