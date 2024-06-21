package fpt.aptech.server.Service;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.Subject;
import fpt.aptech.server.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubejctSer implements ISubjectSer{
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Integer subjectid) {
        Optional<Subject> classs = subjectRepository.findById(subjectid);
        classs.ifPresent(subjectRepository::delete);
    }

    @Override
    public Subject getSubject(Integer subjectid) {
        return subjectRepository.findById(subjectid).orElse(null) ;
    }


}
