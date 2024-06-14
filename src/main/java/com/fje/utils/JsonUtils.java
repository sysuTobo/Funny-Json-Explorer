package com.fje.utils;

import com.fje.utils.json.JSONComponent;
import com.fje.utils.json.JSONComposite;
import com.fje.utils.json.JSONLeaf;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {
    public static boolean hasNext(JSONObject jsonObject, String key) {
        int index = 0;
        for (String nextKey : jsonObject.keySet()) {
            if (nextKey.equals(key)) {
                return index < jsonObject.length() - 1;
            }
            index++;
        }
        return false;
    }

    // 解析 JSONObject 并返回 JSONComponent
    public static JSONComponent parseJSONObject(JSONObject jsonObject) {
        JSONComposite composite = new JSONComposite(jsonObject);
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                composite.add(parseJSONObject((JSONObject) value));
            } else if (value instanceof JSONArray) {
                composite.add(parseJSONArray((JSONArray) value, key));
            } else {
                composite.add(new JSONLeaf(key, value));
            }
        }
        return composite;
    }


    // 解析带键名的 JSONArray 并返回 JSONComponent
    public static JSONComponent parseJSONArray(JSONArray jsonArray, String key) {
        JSONComposite composite = new JSONComposite(jsonArray);
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                composite.add(parseJSONObject((JSONObject) value));
            } else if (value instanceof JSONArray) {
                composite.add(parseJSONArray((JSONArray) value, key + "[" + i + "]"));
            } else {
                composite.add(new JSONLeaf(key + "[" + i + "]", value));
            }
        }
        return composite;
    }
}
