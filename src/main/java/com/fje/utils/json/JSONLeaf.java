package com.fje.utils.json;

import org.json.JSONObject;

//public class JSONLeaf implements JSONComponent {
//    private JSONObject JsonObject;
//    private JSONArray JsonArray;
//
//
//
//    public JSONLeaf(JSONObject JsonObject) {
//        this.JsonObject = JsonObject;
//    }
//
//    public JSONLeaf(JSONArray JsonArray) {
//        this.JsonArray = JsonArray;
//    }
//
//    @Override
//    public JSONObject getJSONObject() {
//        return this.JsonObject;
//    }
//
//    public JSONArray getJsonArray(){
//        return this.JsonArray;
//    }
//
//}
public class JSONLeaf implements JSONComponent {
    private String key;
    private Object value;

    public JSONLeaf(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public JSONObject getJSONObject() {
        JSONObject obj = new JSONObject();
        obj.put(key, value);
        return obj;
    }

}




