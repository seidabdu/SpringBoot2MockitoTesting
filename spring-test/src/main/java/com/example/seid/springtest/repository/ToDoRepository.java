package com.example.seid.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seid.springtest.model.ToDo;


@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
