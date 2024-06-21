package fpt.aptech.server.Service;

import fpt.aptech.server.Model.EducationLevel;

import java.util.List;

public interface IEducationlevelSer {

    List<EducationLevel> getAllEducationLevels();

    EducationLevel saveEducationLevel(EducationLevel educationLevel);
    void deleteEducationLevel(Integer levelid);

    EducationLevel getEducationLevel(Integer levelid);
}
