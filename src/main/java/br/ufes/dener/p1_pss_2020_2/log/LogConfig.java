package br.ufes.dener.p1_pss_2020_2.log;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class LogConfig {

    private static JSONArray jsonArray = new JSONArray();
    private static StringBuilder xmlArray = new StringBuilder();
    private static List<String> txtArray = new ArrayList();

    public static JSONArray getJsonArray() {
        return jsonArray;
    }

    public static void setJsonArray(JSONArray jsonArray) {
        LogConfig.jsonArray = jsonArray;
    }

    public static StringBuilder getXmlArray() {
        return xmlArray;
    }

    public static void setXmlArray(StringBuilder xmlArray) {
        LogConfig.xmlArray = xmlArray;
    }

    public static List<String> getTxtArray() {
        return txtArray;
    }

    public static void setTxtArray(List<String> txtArray) {
        LogConfig.txtArray = txtArray;
    }
}
