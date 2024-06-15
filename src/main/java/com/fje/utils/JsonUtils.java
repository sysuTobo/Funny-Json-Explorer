package com.fje.utils;

import com.fje.JsonExplorer;
import com.fje.utils.json.JSONComponent;
import com.fje.utils.json.JSONComposite;
import com.fje.utils.json.JSONLeaf;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    public static String fromFile2String(String fileName) {
        // 创建一个 File 对象，表示要读取的文件
        String filePath = JsonExplorer.class.getClassLoader().getResource("").getPath()+fileName;
        File file = new File(filePath);
        // 创建一个 StringBuilder 对象，用来存储读取到的字符串
        StringBuilder sb = new StringBuilder();
        try {
            // 创建一个 FileReader 对象，用来读取文件的字符流
            FileReader fr = new FileReader(file);
            // 创建一个 BufferedReader 对象，用来缓冲字符流，并提供按行读取的方法
            BufferedReader br = new BufferedReader(fr);
            // 定义一个变量，用来存储每行的内容
            String line;
            // 循环读取每一行，直到文件结束
            while ((line = br.readLine()) != null) {
                // 将每行的内容追加到 StringBuilder 中，并添加换行符
                sb.append(line).append("\n");
            }
            // 关闭 BufferedReader 和 FileReader
            br.close();
            fr.close();
        } catch (IOException e) {
            // 处理异常
            e.printStackTrace();
        }
        // 将 StringBuilder 转换为字符串，并打印输出
        String json = sb.toString();
        return json;
    }

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
