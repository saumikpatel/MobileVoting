package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Vote extends Activity {
    private String e;
    private String[] entryArray;
    protected int i1;
    LinearLayout l1;
    private String[] loginArray;
    private String n;
    private String p;
    private String[] partyArray;
    int q = 0;
    RadioButton[] rb;
    RadioGroup rg1;
    private String s;
    private String s1;
    private String s4;
    String str;
    private String[] t;
    private String temp;
    private String u;
    public int x = 0;
    int y = 0;
    private int z;

    protected void onCreate(Bundle savedInstanceState) {
        InputStreamReader isr;
        char[] inputBuffer;
        int charRead;
        InputStreamReader isr1;
        char[] inputBuffer1;
        int charRead1;
        Bundle b;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vote);
        this.rg1 = (RadioGroup) findViewById(R.id.rg1);
        this.l1 = (LinearLayout) findViewById(R.id.l1);
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
            if (this.p != null) {
                this.partyArray = this.p.split(",");
            } else {
                Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                isr1 = new InputStreamReader(openFileInput("login.txt"));
                inputBuffer1 = new char[100];
                while (true) {
                    charRead1 = isr1.read(inputBuffer1);
                    if (charRead1 <= 0) {
                        break;
                    }
                    this.s += String.copyValueOf(inputBuffer1, 0, charRead1);
                    inputBuffer1 = new char[100];
                    System.out.print("temp is " + this.s);
                }
                if (this.s == null) {
                    this.loginArray = this.s.split(",");
                } else {
                    Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
                }