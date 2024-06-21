package fpt.aptech.server.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

@Table(name = "educationlevel")

public class EducationLevel {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "levelid" , nullable = false)
    private Integer levelid;

    @Column(name = "levelname"  ,length = 100)
    private String levelname;

    @Column(name = "leveldescription"  ,length = 100)
    private String leveldescription;
    @JsonIgnore
    @OneToMany(mappedBy = "levelid")

    private List<Classs> classsList ;
}
