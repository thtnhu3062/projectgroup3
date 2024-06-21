package fpt.aptech.server.Service;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.EducationLevel;

import java.util.List;

public interface IClasssSer {

    List<Classs> getAllClasss();

    Classs saveClasss(Classs classs);
    void deleteClasss(Integer classid);

    Classs getClasss(Integer classsid);
}
