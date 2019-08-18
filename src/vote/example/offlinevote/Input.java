package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Input extends Activity {
    Button b1;
    EditText e1;
    LinearLayout l1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        this.e1 = (EditText) findViewById(R.id.e1);
        this.b1 = (Button) findViewById(R.id.b1);
        this.l1 = (LinearLayout) findViewById(R.id.l1);
        this.b1.setOnClickListener(new OnClickListener() {
            private String k;
            private int m;
            private String n;

            public void onClick(View arg0) {
                this.k = Input.this.e1.getText().toString();
                this.m = Integer.parseInt(this.k);
                if (this.k.equals("")) {
                    Toast.makeText(Input.this.getBaseContext(), "please enter the number", 1).show();
                } else if (this.m < 2 || this.m > 100) {
                    Toast.makeText(Input.this.getBaseContext(), "please enter the number between 2 to 100 ", 1).show();
                } else {
                    Bundle b = new Bundle();
                    b.putString("input", this.k);
                    Intent in = new Intent(Input.this, Elector.class);
                    in.putExtras(b);
                    Input.this.startActivity(in);
                    Input.this.finish();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.input, menu);
        return true;
    }
}
