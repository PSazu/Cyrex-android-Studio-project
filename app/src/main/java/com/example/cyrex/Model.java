package com.example.cyrex;

public class Model {
    private String subText, subText2, synopsis, description,title, trailer, youtubeId, url;
    private int image, arrow,rate,imageB;
    public Model(String title, int imageB, String Subtext, String SubText2, String Title, String descriptions, int image, int arrow, String trailer, String youTubeId, String URL){
        this.title=title;
        this.imageB=imageB;
        this.subText = Subtext;
        this.subText2 = SubText2;
        this.synopsis = Title;
        this.description = descriptions;
        this.image = image;
        this.arrow = arrow;
        this.trailer = trailer;
        this.youtubeId=youTubeId;
        this.url = URL;
    }

    public String getUrl() {
        return url;
    }

    public Model(String s, int identifier, String action_, String rpg, String synopsis, String s1, int identifier1) {
    }

    public int getImageB(){return imageB;}
    public String gettitle(){return title;}
    public String getSubText() {
        return subText;
    }

    public String getSubText2() {
        return subText2;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDescription() {
        return description;
    }

    public String getTrailer() {
        return trailer;
    }

    public int getImage() {
        return image;
    }
    public int getArrow() {
        return arrow;
    }
    public String getYoutubeId(){
        return youtubeId;
    }
}
