package fpt.aptech.server.Service;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.EducationLevel;
import fpt.aptech.server.Model.Subject;
import fpt.aptech.server.Repository.ClasssRepository;
import fpt.aptech.server.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasssSer implements  IClasssSer{
    @Autowired
    ClasssRepository classsRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public List<Classs> getAllClasss() {
        return classsRepository.findAll();
    }

    @Override
    public Classs saveClasss(Classs classs) {
        return classsRepository.save(classs);
    }


    @Override
    public void deleteClasss(Integer classsid) {
        Optional<Classs> optionalClasss = classsRepository.findById(classsid);
        if (optionalClasss.isPresent()) {
            Classs classs = optionalClasss.get();
            List<Subject> subjectList = subjectRepository.findByClasssid(classs);
            if (!subjectList.isEmpty()) {
                throw new IllegalStateException("Cannot delete Classs while there are associated subject.");
            }
            classsRepository.delete(classs);
        } else {
            throw new IllegalStateException("Classs not found.");
        }
    }

    @Override
    public Classs getClasss(Integer classsid) {
        return classsRepository.findById(classsid).orElse(null) ;
    }
}
