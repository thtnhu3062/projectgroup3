package fpt.aptech.server.Service;

import fpt.aptech.server.Model.Classs;
import fpt.aptech.server.Model.Subject;

import java.util.List;

public interface ISubjectSer {


    List<Subject> getAllSubject();

    Subject saveSubject(Subject subject);
    void deleteSubject(Integer subjectid);

    Subject getSubject(Integer subjectid);
}
