package top.sunlee.sunjulei.face;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import top.sunlee.sunjulei.face.com.baidu.translate.demo.Languages;

public class MainActivity extends AppCompatActivity {

    private EditText source_et;
    private TextView result_tv;
    private Spinner spListTo;
    private Spinner spListFrom;
    private Button save_bt;
    private ImageButton playFrom;
    private ImageButton playTo;

    private Languages langFrom = null;
    private Languages langTo = null;
    private Speech speech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        byViewId();


    }

    //绑定组件
    void byViewId() {
        source_et = findViewById(R.id.source);
        result_tv = findViewById(R.id.result);
        spListFrom = findViewById(R.id.langfrom);
        spListTo = findViewById(R.id.langto);
        save_bt = findViewById(R.id.save);
        playFrom = findViewById(R.id.playFrom);
        playTo = findViewById(R.id.playTo);


        //翻译文本
        save_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Tran t = new Tran();

                        String str = source_et.getText().toString();//得到输入的文本
                        String result;
                        try {
                            langFrom = new Languages(spListFrom.getSelectedItem().toString());
                            langTo = new Languages(spListTo.getSelectedItem().toString());
                            JSONObject json = new JSONObject(t.test(str,langFrom.getLang(), langTo.getLang()));
                            JSONArray json2 = json.getJSONArray("trans_result");
                            JSONObject json3 = json2.getJSONObject(0);
                            result = json3.getString("dst");
                            result_tv.setText(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        //播放声音
        playTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = result_tv.getText().toString();
                if (text !="") {
                    speech = new Speech(MainActivity.this);
                    speech.play(text);
                }else {
                    Toast.makeText(MainActivity.this,"播放文本为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        playFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = source_et.getText().toString();
                if (text !="") {
                    speech = new Speech(MainActivity.this);
                    speech.play(text);
                }else {
                    Toast.makeText(MainActivity.this,"播放文本为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
