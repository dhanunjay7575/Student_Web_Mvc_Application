package com.jay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
