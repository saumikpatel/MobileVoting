package vote.example.offlinevote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class End extends Activity {
    Button admin;
    Button exit;
    Button home;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        this.home = (Button) findViewById(R.id.home);
        this.exit = (Button) findViewById(R.id.exit);
        this.admin = (Button) findViewById(R.id.admin);
        this.home.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                End.this.startActivity(new Intent(End.this, MainActivity.class));
                End.this.finish();
            }
        });
        this.admin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                End.this.startActivity(new Intent(End.this, Admin.class));
                End.this.finish();
            }
        });
        this.exit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        });
    }
}
