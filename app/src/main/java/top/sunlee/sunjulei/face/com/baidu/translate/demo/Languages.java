package top.sunlee.sunjulei.face.com.baidu.translate.demo;

/**
 * Created by Administrator on 2019/3/12 0012.
 */

public class Languages {
    String lang;

    public Languages(String lang) {
        switch (lang) {
            case "自动":
                this.lang = "auto";
                break;
            case "英语":
                this.lang = "en";
                break;
            case "中文":
                this.lang = "zh";
                break;
            case "粤语":
                this.lang = "yue";
                break;
            case "文言文":
                this.lang = "wyw";
                break;
            case "日语":
                this.lang = "jp";
                break;
            case "繁体中文":
                this.lang = "cht";
                break;

            case "韩语":
                this.lang = "kor";
                break;
            case "法语":
                this.lang = "fra";
                break;
            case "西班牙语":
                this.lang = "spa";
                break;
            case "俄语":
                this.lang = "ru";
                break;
            case "阿拉伯语":
                this.lang = "ara";
                break;
            case "越南":
                this.lang = "de";
                break;
            case "德语":
                this.lang = "vie";
                break;

            default:
                this.lang = "zh";
        }
    }

    public String getLang() {
        return lang;
    }
}
