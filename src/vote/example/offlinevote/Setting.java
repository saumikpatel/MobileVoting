package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Setting extends Activity {
    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        this.i1 = (ImageView) findViewById(R.id.i1);
        this.i2 = (ImageView) findViewById(R.id.i2);
        this.i3 = (ImageView) findViewById(R.id.i3);
        this.i4 = (ImageView) findViewById(R.id.i4);
        this.i1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Setting.this.startActivity(new Intent(Setting.this, Adduser.class));
                Setting.this.finish();
            }
        });
        this.i2.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Setting.this.startActivity(new Intent(Setting.this, Resetuser.class));
            }
        });
        this.i3.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                try {
                    if (Setting.this.getBaseContext().getFileStreamPath("vote.txt").exists()) {
                        OutputStreamWriter osw = new OutputStreamWriter(Setting.this.openFileOutput("vote.txt", 0));
                        for (int i = 0; i < 100; i++) {
                            osw.write(",0");
                        }
                        osw.flush();
                        osw.close();
                        Toast.makeText(Setting.this.getBaseContext(), "Vote Successfully reseted", 1).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.i4.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Setting.this.startActivity(new Intent(Setting.this, Input.class));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }
}
