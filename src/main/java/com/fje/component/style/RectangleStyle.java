package com.fje.component.style;

import com.fje.component.icon.IIconConfig;
import com.fje.utils.json.JSONComponent;
import com.fje.utils.json.JSONComposite;
import com.fje.utils.json.JSONLeaf;
import org.json.JSONArray;
import org.json.JSONObject;

public class RectangleStyle extends Style{
    private Boolean isFirst;

    public RectangleStyle() {
        this.isFirst = true;
    }

    @Override
    public void format(String json, IIconConfig icon) {
        JSONObject jsonObject = new JSONObject(json);
        JSONComponent root = parseJSONObject(jsonObject); // 转化为 JSONComponent
        displayJsonObject(root.getJSONObject(), 0, icon);
    }
    // 递归显示 JSONObject
    private void displayJsonObject(JSONObject jsonObject, int indent, IIconConfig icon) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            boolean isObject = value instanceof JSONObject;
            boolean isArray = value instanceof JSONArray;
            boolean hasNext = hasNext(jsonObject, key);
            Boolean isLast = !(isObject || isArray) && !hasNext;
            // 打印缩进和连接线
            printIndent(indent, isLast);
            if(isFirst){
                System.out.print("┌─ ");
            }
            else if(isLast){
                System.out.print("└─ ");
            }
            else{
                System.out.print("├─ ");
            }
            if (!(isObject || isArray)) {
                System.out.print(icon.getIconLeaf() + key + ": " + value);
                // 计算需要补齐的长度
                int paddingLength = 50 - key.length()- value.toString().length() - indent * 3 - 2;
                for (int i = 0; i < paddingLength; i++) {
                    System.out.print("─");
                }
                if(isFirst){
                    System.out.print("─┐");
                }
                else if(isLast){
                    System.out.print("─┘");
                }
                else{
                    System.out.print("─┤");
                }
                System.out.println();
            }else{
                if(isObject && ((JSONObject) value).keySet().size() == 0){
                    System.out.print(icon.getIconLeaf() + key);
                }else{
                    System.out.print(icon.getIconNode() + key);
                }
                // 计算需要补齐的长度
                int paddingLength = 50 - key.length() - indent * 3;
                for (int i = 0; i < paddingLength; i++) {
                    System.out.print("─");
                }
                if(isFirst){
                    System.out.print("─┐");
                }
                else if(isLast){
                    System.out.print("─┘");
                }
                else{
                    System.out.print("─┤");
                }
                System.out.println();
            }
            isFirst = false;

            // 递归处理对象和数组
            if (isObject) {
                displayJsonObject((JSONObject) value, indent + 1,icon);
            } else if (isArray) {
                displayJsonArray((JSONArray) value, indent + 1,icon);
            }

        }
    }

    // 递归显示 JSONArray
    private void displayJsonArray(JSONArray jsonArray, int indent, IIconConfig icon) {
        for (int i = 0; i < jsonArray.length(); i++) {

            Object value = jsonArray.get(i);
            boolean isObject = value instanceof JSONObject;
            boolean isArray = value instanceof JSONArray;
            boolean hasNext = i < jsonArray.length() - 1;
            boolean isLast = !(isObject || isArray) && !hasNext;
            // 打印缩进和连接线
            printIndent(indent, isLast);
            if(isFirst){
                System.out.print("┌─ ");
            }
            else if(isLast){
                System.out.print("└─ ");
            }
            else{
                System.out.print("├─ ");
            }
            // 递归处理对象和数组，否则直接打印值
            if (isObject) {
                displayJsonObject((JSONObject) value, indent + 1,icon);
            } else if (isArray) {
                displayJsonArray((JSONArray) value, indent + 1,icon);
            } else {
                System.out.print(value);
                // 计算需要补齐的长度
                int paddingLength = 50 - value.toString().length() - indent * 3;
                for (int j = 0; j < paddingLength; j++) {
                    System.out.print("─");
                }
                if(isFirst){
                    System.out.print("─┐");
                }
                else if(isLast){
                    System.out.print("─┘");
                }
                else{
                    System.out.print("─┤");
                }
                System.out.println();
            }

        }
    }


    // 打印缩进
    private void printIndent(int indent, Boolean isLast) {
        if(!isLast){
            for (int i = 0; i < indent; i++) {
                System.out.print("│  ");
            }
        }
        else{
            for (int i = 0; i < indent; i++) {
                System.out.print("└──");
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
