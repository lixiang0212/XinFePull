package com.lx.xingexgpush;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tencent.android.tpush.XGBasicPushNotificationBuilder;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushServiceV3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        Intent service = new Intent(context, XGPushServiceV3.class);
        context.startService(service);
        XGPushManager.registerPush(context, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                Log.i("AAA","Success:"+i+"i:"+o.toString());
            }

            @Override
            public void onFail(Object o, int i, String s) {
                Log.i("AAA","Failed:"+i+"i:"+o.toString()+s);
            }
        });
     //   XGPushManager.setDefaultNotificationBuilder(context,new XGBasicPushNotificationBuilder().);
    }
}
