package fpt.aptech.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fpt.aptech.client.Model.Classs;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
public class EducationLeveldto {
    private Integer levelid;

    @NotEmpty(message = "Name Level is required...")
    @Size(min = 2, max = 100, message = "Name 2 to 100 characters")
    private String levelname;

    @Size(min = 2, max = 100, message = "Description 2 to 100 characters")
    private String leveldescription;

    @JsonIgnore
    private List<Classs> classsList;

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public @NotEmpty(message = "Name Level is required...") @Size(min = 2, max = 100, message = "Name 2 to 100 characters") String getLevelname() {
        return levelname;
    }

    public void setLevelname(@NotEmpty(message = "Name Level is required...") @Size(min = 2, max = 100, message = "Name 2 to 100 characters") String levelname) {
        this.levelname = levelname;
    }

    public @Size(min = 2, max = 100, message = "Description 2 to 100 characters") String getLeveldescription() {
        return leveldescription;
    }

    public void setLeveldescription(@Size(min = 2, max = 100, message = "Description 2 to 100 characters") String leveldescription) {
        this.leveldescription = leveldescription;
    }

    public List<Classs> getClasssList() {
        return classsList;
    }

    public void setClasssList(List<Classs> classsList) {
        this.classsList = classsList;
    }
}
