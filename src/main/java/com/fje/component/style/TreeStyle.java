package com.fje.component.style;

import com.fje.component.icon.IIconConfig;
import com.fje.utils.json.JSONComponent;
import com.fje.utils.json.JSONComposite;
import com.fje.utils.json.JSONLeaf;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TreeStyle extends Style{
    public TreeStyle() {
    }

    @Override
    public void format(String json, IIconConfig icon) {
        JSONObject jsonObject = new JSONObject(json); // 解析 JSON 字符串为 JSONObject
        JSONComponent root = parseJSONObject(jsonObject); // 转化为 JSONComponent
        List<Boolean> list = new ArrayList(); // 用于跟踪树的层级结构
        formatJsonObject(root.getJSONObject(), 0, list, icon); // 显示 JSON 结构
    }
    // 递归显示 JSONComponent
    private void formatJsonObject(JSONObject jsonObject, int indent, List<Boolean> list, IIconConfig icon) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            boolean isObject = value instanceof JSONObject;
            boolean isArray = value instanceof JSONArray;
            boolean hasNext = hasNext(jsonObject, key);

            // 打印缩进和连接线
            printIndent(indent, list);
            System.out.print(!hasNext ? "└─" : "├─");
            list.add(hasNext);
            // 如果值是对象或数组，则只打印键，否则打印键值对
            if(isObject || isArray){
                if(isObject && ((JSONObject) value).keySet().size() == 0){
                    System.out.println(icon.getIconLeaf() + key);
                }else{
                    System.out.println(icon.getIconNode() + key);
                }

            }else{
                System.out.println(icon.getIconLeaf() + key + ": " + value);
            }
            // 递归处理对象和数组
            if (isObject) {
                formatJsonObject((JSONObject) value, indent + 1, list,icon);
            } else if (isArray) {
                formatJsonArray((JSONArray) value, indent + 1, list, icon);
            }
            list.remove(indent);
        }
    }

    // 递归显示 JSONArray
    private void formatJsonArray(JSONArray jsonArray, int indent, List<Boolean> list, IIconConfig icon) {
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            boolean isObject = value instanceof JSONObject;
            boolean isArray = value instanceof JSONArray;
            boolean hasNext = i < jsonArray.length() - 1;

            // 打印缩进和连接线
            printIndent(indent, list);
            System.out.print(!hasNext ? "└─" : "├─");
            list.add(hasNext);
            // 递归处理对象和数组，否则直接打印值
            if (isObject) {
                formatJsonObject((JSONObject) value, indent + 1, list,icon);
            } else if (isArray) {
                formatJsonArray((JSONArray) value, indent + 1, list,icon);
            } else {
                System.out.println(icon.getIconLeaf() + value);
            }
            list.remove(indent);
        }
    }

    // 打印缩进
    private void printIndent(int indent, List<Boolean> list) {
        for (int i = 0; i < indent; i++) {
            if (list.get(i)) {
                System.out.print("│  ");
            } else {
                System.out.print("   ");
            }
        }
    }

    // 检查键在 JSONObject 中是否有下一个键
    private boolean hasNext(JSONObject jsonObject, String key) {
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
    private JSONComponent parseJSONObject(JSONObject jsonObject) {
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
    private JSONComponent parseJSONArray(JSONArray jsonArray, String key) {
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
