package vote.example.offlinevote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Elector extends Activity {
    EditText e;
    EditText[] et;
    private String h;
    private int j = 0;
    LinearLayout l1;
    String[] str;
    private int t;
    String temp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elector);
        this.l1 = (LinearLayout) findViewById(R.id.l1);
        this.h = getIntent().getExtras().getString("input");
        this.t = Integer.parseInt(this.h);
        this.et = new EditText[this.t];
        this.j = 0;
        while (this.j < this.t) {
            this.et[this.j] = new EditText(getBaseContext());
            this.et[this.j].setId(this.j);
            this.et[this.j].setHint("enter leader name  " + this.j);
            this.et[this.j].setPadding(20, 20, 20, 20);
            this.l1.addView(this.et[this.j]);
            this.j++;
        }
        Button b2 = new Button(getBaseContext());
        b2.setText("save");
        b2.setId(50);
        this.l1.addView(b2);
        b2.getId();
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                OutputStreamWriter osw;
                try {
                    osw = new OutputStreamWriter(Elector.this.openFileOutput("party.txt", 0));
                    Elector.this.j = 0;
                    while (Elector.this.j < Elector.this.t) {
                        if (Elector.this.et[Elector.this.j].getText().toString().equals("")) {
                            Elector.this.et[Elector.this.j].setText("No Name Provided");
                        }
                        osw.append("," + Elector.this.et[Elector.this.j].getText().toString());
                        Elector elector = Elector.this;
                        elector.j = elector.j + 1;
                    }
                    osw.flush();
                    osw.close();
                    Toast.makeText(Elector.this.getBaseContext(), "saved", 1).show();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                try {
                    osw = new OutputStreamWriter(Elector.this.openFileOutput("input.txt", 0));
                    osw.write(Elector.this.h);
                    osw.flush();
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (Elector.this.getBaseContext().getFileStreamPath("vote.txt").exists()) {
                        osw = new OutputStreamWriter(Elector.this.openFileOutput("vote.txt", 0));
                        for (int i = 0; i < 100; i++) {
                            osw.write(",0");
                        }
                        osw.flush();
                        osw.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                Elector.this.finish();
            }
        });
    }

    public void onStop() {
        super.onStop();
        finish();
    }
}
