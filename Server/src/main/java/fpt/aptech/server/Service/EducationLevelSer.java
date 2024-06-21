package fpt.aptech.server.Service;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.EducationLevel;
import fpt.aptech.server.Repository.ClasssRepository;
import fpt.aptech.server.Repository.EducationlevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationLevelSer implements IEducationlevelSer {
    @Autowired
    EducationlevelRepository educationlevelRepository;
    @Autowired
    ClasssRepository classRepository;
    @Override
    public List<EducationLevel> getAllEducationLevels() {
        return educationlevelRepository.findAll() ;
    }

    @Override
    public EducationLevel saveEducationLevel(EducationLevel educationLevel) {
        return educationlevelRepository.save(educationLevel) ;
    }

    @Override
    public void deleteEducationLevel(Integer levelid) {
        Optional<EducationLevel> optionalEducationLevel = educationlevelRepository.findById(levelid);
        if (optionalEducationLevel.isPresent()) {
            EducationLevel educationLevel = optionalEducationLevel.get();
            List<Classs> classsList = classRepository.findByLevelid(educationLevel);
            if (!classsList.isEmpty()) {
                throw new IllegalStateException("Cannot delete EducationLevel while there are associated classes.");
            }
            educationlevelRepository.delete(educationLevel);
        } else {
            throw new IllegalStateException("EducationLevel not found.");
        }
    }

    @Override
    public EducationLevel getEducationLevel(Integer levelid) {
        return educationlevelRepository.findById(levelid).orElse(null) ;
    }
}
