package com.pritikjain.glideexample;

/**
 * Created by pritijain on 08/01/2017.
 */

public class User {

    String name;
    String image;

    public User(String name , String image)
    {
        this.name = name;
        this.image = image;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
