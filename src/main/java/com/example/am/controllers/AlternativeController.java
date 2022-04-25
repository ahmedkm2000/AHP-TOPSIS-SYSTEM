package com.example.am.controllers;

import com.example.am.models.Alternative;
import com.example.am.repository.AlternativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")

public class AlternativeController {
    @Autowired
    private AlternativeRepository alternativeRepository;

    @GetMapping("/alternatives")
    public List<Alternative> getAllAlternatives(){
        return alternativeRepository.findAll();
    }
    @GetMapping("/alternatives/{id}")
    public Optional<Alternative> getAlternativeById(@PathVariable long id){
       return alternativeRepository.findById(id);
    }
    @PostMapping("/alternatives")
    public Alternative saveAlternative(@RequestBody Alternative alternative){
       return alternativeRepository.save(alternative);
    }
    @PutMapping("/alternatives/{id}")
    public Alternative updateAlternative(@PathVariable long id ,@RequestBody Alternative alternative) throws Exception {
        Alternative updatedAlternative = alternativeRepository.findById(id).orElseThrow(()-> new Exception("Alternative doesn't exist"));;
        updatedAlternative.setName(alternative.getName());
        return alternativeRepository.save(updatedAlternative);
    }
    @PutMapping("/alternatives/cii/{id}")
    public Alternative updateRankAndCii(@PathVariable long id ,@RequestBody Alternative alternative) throws Exception {
        Alternative updatedAlternative = alternativeRepository.findById(id).orElseThrow(()-> new Exception("Alternative doesn't exist"));;
        updatedAlternative.setCii(alternative.getCii());
        updatedAlternative.setRank(alternative.getRank());
        return alternativeRepository.save(updatedAlternative);
    }
    @DeleteMapping("alternatives/{id}")
    public void deleteCriterion(@PathVariable long id){
        alternativeRepository.deleteById(id);
    }


}

