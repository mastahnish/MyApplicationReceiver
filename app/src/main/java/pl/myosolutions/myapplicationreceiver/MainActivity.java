package pl.myosolutions.myapplicationreceiver;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver receiver = new MyBroadcastReceiver();
    IntentFilter intentFilters = new IntentFilter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilters.addAction("com.example.piotr.myapplication.show.product");
        registerReceiver(receiver, intentFilters);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
