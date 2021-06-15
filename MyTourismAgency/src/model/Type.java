package model;

public enum Type {
    SEA(1, "sea"),
    MOUNTAIN(2, "mountain"),
    CITYBREAK(3, "city break");

    private int id;
    private String type;

    Type(int id, String type){
        this.id = id;
        this.type = type;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }

}
