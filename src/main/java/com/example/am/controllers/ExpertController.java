package com.example.am.controllers;

import com.example.am.models.Expert;
import com.example.am.models.Project;
import com.example.am.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ExpertController {
    @Autowired
    private ExpertRepository expertRepository;
    @GetMapping("/experts")
    public List<Expert> getAllExperts(){
        return expertRepository.findAll();
    }
    @PutMapping("/experts/{id}")
    public Expert updateExpert(@PathVariable long id , @RequestBody Expert expert) throws Exception {
        Expert updatedExpert = expertRepository.findById(id).orElseThrow(()-> new Exception("Expert doesn't exist"));
        if(expert.getWeight()!=null){
        updatedExpert.setWeight(expert.getWeight());
        }
        if(expert.getAlternativeMatrix()!=null){
        updatedExpert.setAlternativeMatrix(expert.getAlternativeMatrix());
        }
        return expertRepository.save(updatedExpert);
    }

}
