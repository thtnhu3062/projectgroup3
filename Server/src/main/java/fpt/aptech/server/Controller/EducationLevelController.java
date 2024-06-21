package fpt.aptech.server.Controller;


import fpt.aptech.server.Model.EducationLevel;
import fpt.aptech.server.Service.IEducationlevelSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/edu")
public class EducationLevelController {
    @Autowired
    IEducationlevelSer educationlevelSer;

    @GetMapping("/")
        @ResponseStatus(HttpStatus.OK)
    public List<EducationLevel> get(){
        return educationlevelSer.getAllEducationLevels() ;
        }

    @GetMapping("/{classid}")
    @ResponseStatus(HttpStatus.OK)
    public EducationLevel get(@PathVariable("classid") int classid){
        return educationlevelSer.getEducationLevel(classid);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public EducationLevel create(@RequestBody EducationLevel educationLevel){
        return educationlevelSer.saveEducationLevel(educationLevel);
    }

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EducationLevel> update(@RequestBody EducationLevel educationLevel){

        EducationLevel existingLevel = educationlevelSer.getEducationLevel(educationLevel.getLevelid());
        if(existingLevel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        EducationLevel updatedLevel = educationlevelSer.saveEducationLevel(educationLevel);
        return new ResponseEntity<>(updatedLevel, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{levelid}")
    public ResponseEntity<Void> deleteEducationLevel(@PathVariable("levelid") int levelid){
        try {
            educationlevelSer.deleteEducationLevel(levelid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
