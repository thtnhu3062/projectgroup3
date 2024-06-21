package fpt.aptech.server.Repository;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.EducationLevel;
import fpt.aptech.server.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findByClasssid(Classs classs);
}
