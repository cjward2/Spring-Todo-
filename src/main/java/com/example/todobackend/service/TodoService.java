package com.example.todobackend.service;

import com.example.todobackend.model.Todo;
import com.example.todobackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> _todo = todoRepository.findById(id);

        if(_todo.isPresent()) {
            Todo existingTodo = _todo.get();
            existingTodo.setTask(updatedTodo.getTask());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existingTodo);
        }

        return null;
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
