package tw.edu.tut.mis.demo1016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.time.Instant;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Intent it = getIntent();
        String a;
        double b;
        int c;
        a = it.getStringExtra("名稱1號");
        b = it.getDoubleExtra("名稱2號", 0.0 );
        c = it.getIntExtra("名稱自己取", 0 );

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //如果是要直接停下這一個activity
                WriteActivity.this.finish();

                //如果沒有要停下，只是要切換過去而已
                //Intent it = new Intent();
                //it.setClass( WriteActivity.this, MainActivity.class );
                //startActivity( it );
            }
        });

    }
}
