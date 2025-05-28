package com.eryckavel.spring_boot_3.repository;

import com.eryckavel.spring_boot_3.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
