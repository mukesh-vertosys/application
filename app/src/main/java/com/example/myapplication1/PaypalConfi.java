package com.example.myapplication1;

import android.app.Application;

import com.paypal.android.sdk.payments.PayPalConfiguration;


public class PaypalConfi extends Application {
    public static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
    public static final String PAYPAL_CLIENT_ID = "AbPsPZz_rPcWcjFe0NgrS8WMu560W0Bg0S28FF9B8VBjNkxdfz6U5FWmUxgoq37DnGMKGQhVVdDBRddv";
    public static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(PAYPAL_CLIENT_ID).acceptCreditCards(false);
    public static final String DEVELOPER_KEY = "AIzaSyAZNFUcmZA0e5L9L7JnMYQawykpOAYQxTM";


}
