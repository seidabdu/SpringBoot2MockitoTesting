package com.example.seid.springtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.seid.springtest.model.ToDo;
import com.example.seid.springtest.repository.ToDoRepository;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public List<ToDo> getAllToDo() {
		return toDoRepository.findAll();
	}

	@Override
	public ToDo getToDoById(long id) {

		Optional<ToDo> todo = toDoRepository.findById(id);
		return todo.isPresent() ? todo.get() : null;
	}

	@Override
	public ToDo saveToDo(ToDo todo) {
		return toDoRepository.save(todo);
	}

	@Override
	public void removeToDo(ToDo todo) {
		toDoRepository.delete(todo);
	}

}
