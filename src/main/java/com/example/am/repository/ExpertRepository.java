package com.example.am.repository;

import com.example.am.models.Expert;
import com.example.am.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert,Long> {
}
