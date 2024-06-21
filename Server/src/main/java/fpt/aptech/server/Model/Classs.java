package fpt.aptech.server.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "class")
public class Classs {
    @JsonIgnore
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classsid" , nullable = false , length = 20)
    private Integer classsid;
    @JsonCreator
    public Classs(@JsonProperty("classsid") Integer classsid) {
        this.classsid = classsid;
    }
    @Column(name = "classsname" , length = 50)
    private String classsname;

    @ManyToOne()
    @JoinColumn(name = "levelid" , referencedColumnName = "levelid")
    private EducationLevel levelid ;

    @JsonIgnore
    @OneToMany(mappedBy ="classsid")
    private List<Subject> subjectList ;

}
