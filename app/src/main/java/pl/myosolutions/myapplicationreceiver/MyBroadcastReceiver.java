package pl.myosolutions.myapplicationreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = MyBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "onReceive");

        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            long productId = bundle.getLong("PRODUCT_ID_KEY");
            String product = bundle.getString("PRODUCT_KEY");
            String quantity = bundle.getString("QUANTITY_KEY");
            String price = bundle.getString("PRICE_KEY");

            Intent serviceIntent = new Intent(context, MyService.class);
            serviceIntent.putExtra("PRODUCT_ID_KEY", productId);
            serviceIntent.putExtra("PRODUCT_KEY", product);
            serviceIntent.putExtra("QUANTITY_KEY", quantity);
            serviceIntent.putExtra("PRICE_KEY", price);


            ContextCompat.startForegroundService(context, serviceIntent);

            Log.d(TAG, productId + "\n" + product + "\n" + quantity + "\n" + price + "\n");
        }

    }
}
