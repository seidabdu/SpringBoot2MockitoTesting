package com.example.seid.springtest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.seid.springtest.model.ToDo;
import com.example.seid.springtest.repository.ToDoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {

	@MockBean
	private ToDoRepository toDoRepository;

	@Autowired
	@Qualifier("toDoService")
	private ToDoServiceImpl toDoService;

	@Test
	public void testGetAllToDo() {
		List<ToDo> toDoList = new ArrayList<ToDo>();
		toDoList.add(new ToDo(1, "Todo Sample 1", true));
		toDoList.add(new ToDo(2, "Todo Sample 2", true));
		toDoList.add(new ToDo(3, "Todo Sample 3", false));
		when(toDoRepository.findAll()).thenReturn(toDoList);

		List<ToDo> result = toDoService.getAllToDo();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetToDoById() {
		ToDo toDo = new ToDo(1, "Todo Sample 1", true);

		when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDo));
		ToDo result = toDoService.getToDoById(1);
		assertEquals(1, result.getId());
		assertEquals("Todo Sample 1", result.getText());
		assertEquals(true, result.isCompleted());
	}

	@Test
	public void saveToDo() {
		ToDo toDo = new ToDo(8, "Todo Sample 8", true);
		when(toDoRepository.save(toDo)).thenReturn(toDo);
		ToDo result = toDoService.saveToDo(toDo);
		assertEquals(8, result.getId());
		assertEquals("Todo Sample 8", result.getText());
		assertEquals(true, result.isCompleted());
	}

	@Test
	public void removeToDo() {
		ToDo toDo = new ToDo(8, "Todo Sample 8", true);
		toDoService.removeToDo(toDo);
		verify(toDoRepository, times(1)).delete(toDo);
	}

}
