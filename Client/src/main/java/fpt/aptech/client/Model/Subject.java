package fpt.aptech.client.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @JsonIgnore

    private Integer subjectid;
    private String subjectname;


    private Classs classsid ;

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public Classs getClasssid() {
        return classsid;
    }

    public void setClasssid(Classs classsid) {
        this.classsid = classsid;
    }
}
