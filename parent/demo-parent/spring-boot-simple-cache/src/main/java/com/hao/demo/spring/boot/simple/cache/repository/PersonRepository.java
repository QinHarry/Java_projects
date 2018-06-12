package com.hao.demo.spring.boot.simple.cache.repository;

import com.hao.demo.spring.boot.simple.cache.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    public void deleteById(Long id);

    public Optional<Person> findById(Long id);
}
