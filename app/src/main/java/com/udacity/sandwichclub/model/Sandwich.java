package com.udacity.sandwichclub.model;

import com.udacity.sandwichclub.R;
import java.util.List;

public class Sandwich  {

    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;

    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    // method to get a list of ingredients

    public String getIngredientsString(){
        StringBuilder output = new StringBuilder();
        int size = ingredients.size();
        for (int i = 0; i < size-1; i++) {
            output.append(ingredients.get(i) + ", ");
        }
        output.append(" " + MyApplication.getContext().getResources().getString(R.string.and) + " " + ingredients.get(size-1) + ".");

        String stringIngredients = output.toString();
        return stringIngredients;
    }

    // method to get a list of alternative names

    public String getAlsoKnownAsString(){
        StringBuilder output = new StringBuilder();
        int size = alsoKnownAs.size();

        if (size == 1){
                output.append(alsoKnownAs.get(size-1) + ".");
        }
        else if (size > 1){
            for (int i = 0; i < size-1; i++) {
                output.append(alsoKnownAs.get(i) + ", " );
            }
            output.append(" " + MyApplication.getContext().getResources().getString(R.string.and) + " " + alsoKnownAs.get(size-1) + ".");
        }
        else if (size == 0){

            output.append(MyApplication.getContext().getResources().getString(R.string.no_information));
        }

        String stringAlsoKnownAs = output.toString();
        return stringAlsoKnownAs;
    }

    // method to get place of origin

    public String getPlaceOfOriginNoEmpty(){
        String place = "";
        if (placeOfOrigin.isEmpty()){
            place = MyApplication.getContext().getResources().getString(R.string.no_information);
        } else {
            place = placeOfOrigin;
        }
        return place;
    }
}
