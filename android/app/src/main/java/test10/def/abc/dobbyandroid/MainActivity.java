package test10.def.abc.dobbyandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    native int testadd(int a, int b);
    native void hookadd();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.loadLibrary("abcd");
                hookadd();
                int a = testadd(10, 10);
                if(a == 21){
                    Toast.makeText(MainActivity.this, "hook success", Toast.LENGTH_SHORT).show();
                }else if(a == 20){
                    Toast.makeText(MainActivity.this, "hook fail", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "?????", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
