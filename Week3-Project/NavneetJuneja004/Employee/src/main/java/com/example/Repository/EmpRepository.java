package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;

@Repository
public interface EmpRepository extends JpaRepository<Employee, String>{
}