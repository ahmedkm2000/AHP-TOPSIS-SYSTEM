package com.example.am.controllers;

import com.example.am.models.Criterion;
import com.example.am.models.Project;
import com.example.am.repository.CriteriaRepository;
import com.example.am.repository.ProjectRepository;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class CriteriaController {
    @Autowired
    private CriteriaRepository criteriaRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @GetMapping("/criteria")
    public List<Criterion> getAllCriteria(){
        return criteriaRepository.findAll();
    }

    @GetMapping("/criteria/project/{id}")
    public List<Criterion> getCriteriaByProject(@PathVariable long id){
        Project project = projectRepository.findById(id).get();
        return project.getCriteria();
    }

    @GetMapping("/criteria/{id}")
    public Optional<Criterion> getCriterionById(@PathVariable long id){
       return criteriaRepository.findById(id);
    }
    @PostMapping("/criteria")
    public Criterion saveCriterion(@RequestBody Criterion criterion){
       return criteriaRepository.save(criterion);
    }
    @PutMapping("/criteria/{id}")
    public Criterion updateCriterion(@PathVariable long id ,@RequestBody Criterion criterion) throws Exception {
        Criterion updatedCriterion = criteriaRepository.findById(id).orElseThrow(()-> new Exception("Criterion doesn't exist"));;
        updatedCriterion.setName(criterion.getName());
        updatedCriterion.setDescription(criterion.getDescription());
        updatedCriterion.setValue(criterion.getValue());
        updatedCriterion.setWeight(criterion.getWeight());
        return criteriaRepository.save(updatedCriterion);
    }
    @DeleteMapping("/criteria/{id}")
    public void deleteCriterion(@PathVariable long id){
        criteriaRepository.deleteById(id);
    }

}
