package fpt.aptech.server.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "subject")
public class Subject {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectid;
    private String subjectname;

    @ManyToOne()
    @JoinColumn(name = "classsid" )
    private Classs classsid ;
}
