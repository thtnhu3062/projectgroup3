package fpt.aptech.client.Model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;



public class EducationLevel {

    private Integer levelid;


    private String levelname;


    private String leveldescription;


    private List<Classs> classsList ;

    public EducationLevel(){}

    public EducationLevel(Integer levelid){
                this.levelid = levelid;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getLeveldescription() {
        return leveldescription;
    }

    public void setLeveldescription(String leveldescription) {
        this.leveldescription = leveldescription;
    }

    public List<Classs> getClasssList() {
        return classsList;
    }

    public void setClasssList(List<Classs> classsList) {
        this.classsList = classsList;
    }
}

