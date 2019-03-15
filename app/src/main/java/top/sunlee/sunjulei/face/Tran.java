package top.sunlee.sunjulei.face;

import top.sunlee.sunjulei.face.com.baidu.translate.demo.TransApi;

/**
 * Created by Administrator on 2019/3/11 0011.
 */

public class Tran {

    String test(String string,String langFrom,String langTo) {

        // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
        String APP_ID = "20190311000276134";
        String SECURITY_KEY = "k1HfhYyrieK5YtD_j6zB";


        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = string;
        return  api.getTransResult(query, langFrom, langTo);

    }

}
