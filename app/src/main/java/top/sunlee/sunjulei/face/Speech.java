package top.sunlee.sunjulei.face;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/3/14 0014.
 */

public class Speech {

    String appId = "10435734";
    String appKey = "7AVjPIDqAu1MbwiwgcQSrwiG";
    String appSecret = "QZ5sI9rLCjaij81nnCLKCfZv2sLczc2R";

    Context context;
    SpeechSynthesizer mSpeechSynthesizer=null;

    public Speech(Context context) {
        this.context=context;
        initPermission();
        this.mSpeechSynthesizer=SpeechSynthesizer.getInstance();//实例化

    }

    void play(String text){

        mSpeechSynthesizer.setContext(context); // this 是Context的之类，如Activity
//        mSpeechSynthesizer.setSpeechSynthesizerListener(listener);//合成成功后回调
        mSpeechSynthesizer.setAppId(appId);
        mSpeechSynthesizer.setApiKey(appKey,appSecret);
        mSpeechSynthesizer.initTts(TtsMode.ONLINE); // 初始化离在线混合模式，如果只需要在线合成功能，使用 TtsMode.ONLINE
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, "0"); // 设置发声的人声音，在线生效
        mSpeechSynthesizer.speak(text);
    }



    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String permissions[] = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.MODIFY_AUDIO_SETTINGS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_SETTINGS,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_WIFI_STATE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this.context, perm)) {
                toApplyList.add(perm);
                //进入到这里代表没有权限.
            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions((Activity) context, toApplyList.toArray(tmpList), 123);
        }

    }


}
