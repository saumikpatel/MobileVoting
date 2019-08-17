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
				b = getIntent().getExtras();
                this.s1 = b.getString("login");
                this.s4 = b.getString("adhar");
                this.z = Integer.parseInt(this.n);
                this.rb = new RadioButton[this.z];
                this.i1 = 0;
                while (this.i1 < this.z) {
                    this.rb[this.i1] = new RadioButton(this);
                    this.rb[this.i1].setId(this.i1);
                    this.rb[this.i1].setText(this.partyArray[this.i1 + 1]);
                    this.rb[this.i1].setPadding(20, 20, 20, 20);
                    this.rg1.addView(this.rb[this.i1]);
                    this.rb[this.i1] = (RadioButton) findViewById(this.rb[this.i1].getId());
                    this.i1++;
                }
				  this.rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup arg0, int arg1) {
                        Vote vote;
                        OutputStreamWriter osw;
                        switch (Vote.this.rg1.getCheckedRadioButtonId()) {
                            case 0:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[1]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[1] = Vote.this.str;
                                break;
                            case 1:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[2]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[2] = Vote.this.str;
                                break;
                            case 2:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[3]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[3] = Vote.this.str;
                                break;
                            case 3:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[4]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[4] = Vote.this.str;
                                break;
                            case 4:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[5]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[5] = Vote.this.str;
                                break;
                            case 5:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[6]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[6] = Vote.this.str;
                                break;
                            case 6:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[7]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[7] = Vote.this.str;
                                break;
                            case 7:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[8]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[8] = Vote.this.str;
                                break;
                            case 8:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[9]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[9] = Vote.this.str;
                                break;
                            case 9:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[10]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[10] = Vote.this.str;
                                break;
                            case 10:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[11]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[11] = Vote.this.str;
                                break;
                            case 11:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[12]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[12] = Vote.this.str;
                                break;
                            case 12:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[13]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[13] = Vote.this.str;
                                break;
                            case 13:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[14]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[14] = Vote.this.str;
                                break;
                            case 14:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[15]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[15] = Vote.this.str;
                                break;
                            case 15:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[16]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[16] = Vote.this.str;
                                break;
                            case 16:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[17]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[17] = Vote.this.str;
                                break;
                            case 17:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[18]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[18] = Vote.this.str;
                                break;
                            case 18:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[19]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[19] = Vote.this.str;
                                break;
                            case 19:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[20]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[20] = Vote.this.str;
                                break;
                            case 20:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[21]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[21] = Vote.this.str;
                                break;
                            case 21:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[22]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[22] = Vote.this.str;
                                break;
                            case 22:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[23]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[23] = Vote.this.str;
                                break;
                            case 23:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[24]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[24] = Vote.this.str;
                                break;
                            case 24:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[25]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[25] = Vote.this.str;
                                break;
                            case 25:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[26]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[26] = Vote.this.str;
                                break;
                            case 26:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[27]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[27] = Vote.this.str;
                                break;
                            case 27:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[28]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[28] = Vote.this.str;
                                break;
                            case 28:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[29]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[29] = Vote.this.str;
                                break;
                            case 29:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[30]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[30] = Vote.this.str;
                                break;
                            case 30:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[31]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[31] = Vote.this.str;
                                break;
                            case 31:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[32]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[32] = Vote.this.str;
                                break;
                            case 32:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[33]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[33] = Vote.this.str;
                                break;
                            case 33:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[34]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[34] = Vote.this.str;
                                break;
                            case 34:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[35]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[35] = Vote.this.str;
                                break;
                            case 35:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[36]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[36] = Vote.this.str;
                                break;
                            case 36:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[37]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[37] = Vote.this.str;
                                break;
                            case 37:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[38]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[38] = Vote.this.str;
                                break;
                            case 38:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[39]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[39] = Vote.this.str;
                                break;
                            case 39:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[40]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[40] = Vote.this.str;
                                break;
                            case 40:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[41]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[41] = Vote.this.str;
                                break;
                            case 41:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[42]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[42] = Vote.this.str;
                                break;
                            case 42:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[43]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[43] = Vote.this.str;
                                break;
                            case 43:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[44]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[44] = Vote.this.str;
                                break;
                            case 45:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[46]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[46] = Vote.this.str;
                                break;
                            case 46:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[47]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[47] = Vote.this.str;
                                break;
                            case 47:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[48]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[48] = Vote.this.str;
                                break;
                            case 48:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[49]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[49] = Vote.this.str;
                                break;
                            case 49:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[50]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[50] = Vote.this.str;
                                break;
                            case 50:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[51]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[51] = Vote.this.str;
                                break;
                            case 51:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[52]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[52] = Vote.this.str;
                                break;
                            case 52:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[53]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[53] = Vote.this.str;
                                break;
                            case 53:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[54]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[54] = Vote.this.str;
                                break;
                            case 54:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[55]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[55] = Vote.this.str;
                                break;
                            case 55:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[56]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[56] = Vote.this.str;
                                break;
                            case 56:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[57]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[57] = Vote.this.str;
                                break;
                            case 57:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[58]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[58] = Vote.this.str;
                                break;
                            case 59:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[60]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[60] = Vote.this.str;
                                break;
                            case 60:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[61]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[61] = Vote.this.str;
                                break;
                            case 61:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[62]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[62] = Vote.this.str;
                                break;
                            case 62:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[63]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[63] = Vote.this.str;
                                break;
                            case 63:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[64]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[64] = Vote.this.str;
                                break;
                            case 64:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[65]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[65] = Vote.this.str;
                                break;
                            case 65:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[66]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[66] = Vote.this.str;
                                break;
                            case 66:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[67]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[67] = Vote.this.str;
                                break;
                            case 67:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[68]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[68] = Vote.this.str;
                                break;
                            case 68:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[69]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[69] = Vote.this.str;
                                break;
                            case 69:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[70]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[70] = Vote.this.str;
                                break;
                            case 70:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[71]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[71] = Vote.this.str;
                                break;
                            case 71:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[72]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[72] = Vote.this.str;
                                break;
                            case 72:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[73]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[73] = Vote.this.str;
                                break;
                            case 73:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[74]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[74] = Vote.this.str;
                                break;
                            case 74:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[75]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[75] = Vote.this.str;
                                break;
                            case 75:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[76]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[76] = Vote.this.str;
                                break;
                            case 76:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[77]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[77] = Vote.this.str;
                                break;
                            case 77:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[78]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[78] = Vote.this.str;
                                break;
                            case 78:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[79]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[79] = Vote.this.str;
                                break;
                            case 79:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[80]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[80] = Vote.this.str;
                                break;
                            case 80:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[81]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[81] = Vote.this.str;
                                break;
                            case 81:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[82]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[82] = Vote.this.str;
                                break;
                            case 82:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[83]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[83] = Vote.this.str;
                                break;
                            case 83:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[84]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[84] = Vote.this.str;
                                break;
                            case 84:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[85]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[85] = Vote.this.str;
                                break;
                            case 85:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[86]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[86] = Vote.this.str;
                                break;
                            case 86:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[87]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[87] = Vote.this.str;
                                break;
                            case 87:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[88]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[88] = Vote.this.str;
                                break;
                            case 88:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[89]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[89] = Vote.this.str;
                                break;
                            case 89:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[90]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[90] = Vote.this.str;
                                break;
                            case 90:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[91]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[91] = Vote.this.str;
                                break;
                            case 91:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[92]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[92] = Vote.this.str;
                                break;
                            case 92:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[93]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[93] = Vote.this.str;
                                break;
                            case 93:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[94]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[94] = Vote.this.str;
                                break;
                            case 95:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[96]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[96] = Vote.this.str;
                                break;
                            case 96:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[97]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[97] = Vote.this.str;
                                break;
                            case 97:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[98]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[98] = Vote.this.str;
                                break;
                            case 98:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[99]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[99] = Vote.this.str;
                                break;
                            case 99:
                                Vote.this.y = Integer.parseInt(Vote.this.entryArray[100]);
                                vote = Vote.this;
                                vote.y++;
                                Vote.this.str = Integer.toString(Vote.this.y);
                                Vote.this.entryArray[100] = Vote.this.str;
                                break;
                        }
						int j = 0;
                        while (j < Vote.this.loginArray.length) {
                            if (Vote.this.s4.equals(Vote.this.loginArray[j + 2]) && Vote.this.s1.equals(Vote.this.loginArray[j + 1])) {
                                Vote.this.q = Integer.parseInt(Vote.this.loginArray[j + 3]);
                                vote = Vote.this;
                                vote.q++;
                                Vote.this.str = Integer.toString(Vote.this.q);
                                Vote.this.loginArray[j + 3] = Vote.this.str;
                            } else {
                                j += 3;
                            }
                        }
                        try {
                            osw = new OutputStreamWriter(Vote.this.openFileOutput("vote.txt", 0));
                            for (j = 1; j < Vote.this.entryArray.length; j++) {
                                osw.write("," + Vote.this.entryArray[j]);
                            }
                            osw.flush();
                            osw.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                        try {
                            osw = new OutputStreamWriter(Vote.this.openFileOutput("login.txt", 0));
                            for (j = 1; j < Vote.this.loginArray.length; j++) {
                                osw.write("," + Vote.this.loginArray[j]);
                            }
                            osw.flush();
                            osw.close();
                        } catch (IOException ioe2) {
                            ioe2.printStackTrace();
                        }
                        Vote.this.startActivity(new Intent(Vote.this, End.class));
                        Vote.this.finish();
                    }
                });
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
        try {
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
                Toast.makeText(getBaseContext(), "File not loaded successfully!", 1).show();
            } else {
                this.loginArray = this.s.split(",");
            }
        } catch (IOException e222) {
            e222.printStackTrace();
        }
        b = getIntent().getExtras();
        this.s1 = b.getString("login");
        this.s4 = b.getString("adhar");
        this.z = Integer.parseInt(this.n);
        this.rb = new RadioButton[this.z];
        this.i1 = 0;
        while (this.i1 < this.z) {
            this.rb[this.i1] = new RadioButton(this);
            this.rb[this.i1].setId(this.i1);
            this.rb[this.i1].setText(this.partyArray[this.i1 + 1]);
            this.rb[this.i1].setPadding(20, 20, 20, 20);
            this.rg1.addView(this.rb[this.i1]);
            this.rb[this.i1] = (RadioButton) findViewById(this.rb[this.i1].getId());
            this.i1++;
        }
        this.rg1.setOnCheckedChangeListener(/* anonymous class already generated */);
    }
}
