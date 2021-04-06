package com.dtotoentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtotoentity.entities.Student;
@Repository
public interface StudentTRepository extends JpaRepository<Student, Long> {

}
