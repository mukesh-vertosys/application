package com.example.myapplication1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import org.json.JSONException;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int YOUR_RESULT_CODE = 1;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId("AbPsPZz_rPcWcjFe0NgrS8WMu560W0Bg0S28FF9B8VBjNkxdfz6U5FWmUxgoq37DnGMKGQhVVdDBRddv").acceptCreditCards(true);
    private static final int REQUEST_CODE_PAYMENT = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("TAG", "OnCreate A");


        /*File f = new File(String.valueOf("/storage/emulated/0/Android/data/luck.materialdesign.tabsnavigator/files/.MoreData/closed"));
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setDataAndType(Uri.parse(f + File.separator), "file/*");
        startActivityForResult(intent, YOUR_RESULT_CODE);*/

        Button pay = findViewById(R.id.click);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);




           /*     PayPalPayment thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(MainActivity.this, PaymentActivity.class);

                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, PaypalConfi.config);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, PaypalConfi.config);
                startActivityForResult(intent, REQUEST_CODE_PAYMENT);*/


            }
        });
//2.16
    }

    private PayPalPayment getThingToBuy(String paymentIntent) {
        return new PayPalPayment(new BigDecimal("120"), "USD", "moreplex",
                paymentIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null){
                Log.e("sampleapp1", confirm.toJSONObject().toString());

                try {
                    Log.e("sampleapp", confirm.toJSONObject().toString(4));

                    // TODO: send 'confirm' to your server for verification.
                    // see https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
                    // for more details.

                } catch (JSONException e) {
                    Log.e("sampleapp", "an extremely unlikely failure occurred: ", e);
                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.e("sampleapp", "The user canceled.");
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Log.e("sampleapp", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
        }

    }

    @Override
    public void onDestroy () {
        //stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
        Log.e("TAG", "Ondestroy A");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart A");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume A");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop A");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "onRestart A");
    }
}
