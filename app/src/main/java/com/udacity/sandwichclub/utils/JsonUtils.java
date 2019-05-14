package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static JSONObject jsonObject = null;
    private static StringBuilder ka;

    public static Sandwich parseSandwichJson(String json) throws JSONException {


            JSONObject mainJsonObject = new JSONObject(json);

            JSONObject name = mainJsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsA = name.getJSONArray("alsoKnownAs");
            List<String> aka = new ArrayList<>(alsoKnownAsA.length());

            for (int i = 0; i <alsoKnownAsA.length() ; i++) {
                aka.add(alsoKnownAsA.getString(i));
                Log.i("ALSOKNOWNAS", aka.toString());
            }

            String placeOfOrigin = mainJsonObject.getString("placeOfOrigin");
            String description = mainJsonObject.getString("description");
            String image = mainJsonObject.getString("image");

            JSONArray ingredientsA = mainJsonObject.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>(ingredientsA.length());

            for (int i = 0; i < ingredientsA.length() ; i++) {
                ingredients.add(ingredientsA.getString(i));
            }


            return new Sandwich(mainName, aka, placeOfOrigin, description, image, ingredients);


    }
}
