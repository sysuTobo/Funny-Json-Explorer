package com.fje.utils.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONComposite implements JSONComponent {
    private List<JSONComponent> children;

    private JSONObject JsonObject;

    private JSONArray JsonArray;

    public JSONComposite(JSONObject JsonObject) {
        this.JsonObject = JsonObject;
        this.children = new ArrayList();
    }

    public JSONComposite(JSONArray JsonArray) {
        this.JsonArray = JsonArray;
        this.children = new ArrayList();
    }

    public void add(JSONComponent component) {
        children.add(component);
    }

    public JSONObject getJSONObject() {
        return this.JsonObject;
    }

}




