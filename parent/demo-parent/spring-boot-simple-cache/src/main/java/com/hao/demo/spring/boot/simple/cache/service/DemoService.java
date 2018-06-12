package com.hao.demo.spring.boot.simple.cache.service;

import com.hao.demo.spring.boot.simple.cache.entity.Person;
import com.hao.demo.spring.boot.simple.cache.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    PersonRepository personRepository;

    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("Save cache: " + p.getId());
        return p;
    }

    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("Delete cache: " + id);
        personRepository.deleteById(id);
    }

    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findById(person.getId()).get();
        System.out.println("Get cache from: " + person.getId());
        return p;
    }
}
