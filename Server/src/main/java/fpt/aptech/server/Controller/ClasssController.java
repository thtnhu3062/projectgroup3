package fpt.aptech.server.Controller;

import fpt.aptech.server.Model.Classs;

import fpt.aptech.server.Service.IClasssSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/class")
public class ClasssController {
    @Autowired
    IClasssSer classsSer;

    @GetMapping("/")
  public ResponseEntity<List<Classs>> getClasss() {
        try {


     List<Classs> list =  classsSer.getAllClasss() ;
      return new ResponseEntity<>(list, HttpStatus.OK);

    }catch (Exception e){
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{classid}")
    @ResponseStatus(HttpStatus.OK)
    public Classs get(@PathVariable("classid") int classid){
        return classsSer.getClasss(classid) ;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Classs create(@RequestBody Classs classs){
        return classsSer.saveClasss(classs);
    }

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Classs> update(@RequestBody Classs classs){

        Classs existingClass = classsSer.getClasss(classs.getClasssid());
        if(existingClass == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Classs updatedLevel = classsSer.saveClasss(classs);
        return new ResponseEntity<>(updatedLevel, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{classsid}")
    public ResponseEntity<Void> deleteClasss(@PathVariable("classsid") int classsid){
        try {
            classsSer.deleteClasss(classsid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
