package com.example.demo.repo;
import com.example.demo.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<User, Long>{
	
	

}
