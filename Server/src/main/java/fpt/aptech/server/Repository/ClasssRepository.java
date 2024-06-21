package fpt.aptech.server.Repository;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasssRepository extends JpaRepository<Classs, Integer> {
    List<Classs> findByLevelid(EducationLevel educationLevel);
}
