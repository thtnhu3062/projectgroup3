package fpt.aptech.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fpt.aptech.client.Model.Classs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
public class Subjectdto {

    @JsonIgnore

    private Integer subjectid;

    private String subjectname;


    private Integer  classsid ;

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

    public Integer getClasssid() {
        return classsid;
    }

    public void setClasssid(Integer classsid) {
        this.classsid = classsid;
    }
}
