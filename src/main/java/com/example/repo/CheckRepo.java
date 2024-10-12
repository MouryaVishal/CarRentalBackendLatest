package com.example.repo;

import com.example.model.CheckDatabase;
import org.hibernate.annotations.Check;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepo extends JpaRepository<CheckDatabase, Long> {
    // Custom query methods can be defined here
}
