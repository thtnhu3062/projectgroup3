package fpt.aptech.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fpt.aptech.client.Model.EducationLevel;
import fpt.aptech.client.Model.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
public class Classsdto {

    @JsonIgnore

    private Integer classsid;


    private String classsname;



    private Integer levelid ;

    @JsonIgnore

    private List<Subject> subjectList ;

    public Integer getClasssid() {
        return classsid;
    }

    public void setClasssid(Integer classsid) {
        this.classsid = classsid;
    }

    public String getClasssname() {
        return classsname;
    }

    public void setClasssname(String classsname) {
        this.classsname = classsname;
    }

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
