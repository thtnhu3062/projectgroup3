package fpt.aptech.server.Controller;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.Subject;
import fpt.aptech.server.Repository.ClasssRepository;
import fpt.aptech.server.Service.ISubjectSer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    ISubjectSer subjectSer;

    @Autowired
    private ClasssRepository classsRepository;

    @PostMapping("/create")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subjectData) {
        try {
            Classs classs = subjectData.getClasssid();
            if (classs != null) {
                if (classs.getClasssid() != null) {
                    Optional<Classs> existingClass = classsRepository.findById(classs.getClasssid());
                    if (existingClass.isPresent()) {
                        subjectData.setClasssid(existingClass.get());
                    } else {
                        // Lưu đối tượng Classs nếu nó chưa tồn tại trong cơ sở dữ liệu
                        classs = classsRepository.save(classs);
                        subjectData.setClasssid(classs);
                    }
                } else {
                    // Nếu classs không có ID, lưu nó trước
                    classs = classsRepository.save(classs);
                    subjectData.setClasssid(classs);
                }
            }

            // Lưu đối tượng Subject vào cơ sở dữ liệu
            Subject savedSubject = subjectSer.saveSubject(subjectData);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedSubject);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectSer.getAllSubject();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{subjectid}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("subjectid") Integer subjectid) {
        try {
            Subject subject = subjectSer.getSubject(subjectid);
            return ResponseEntity.ok(subject);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }






    @DeleteMapping("/delete/{subjectid}")
    public ResponseEntity<Void> deleteSubject(@PathVariable("subjectid") Integer subjectid) {
        try {
            subjectSer.deleteSubject(subjectid);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
