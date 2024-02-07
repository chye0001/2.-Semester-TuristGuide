package com.example.touristguideapi.model;

public class TouristAttraction {

    private String name;
    private String description;
    private int id;

    public TouristAttraction(String name, String description, int id){
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(int id){
        this.id = id;
    }
}
