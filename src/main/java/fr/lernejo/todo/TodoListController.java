package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {
    private TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping("/api/todo")
    public void add(@RequestBody TodoEntity newTodo) {
        todoRepository.save(newTodo);
    }

    @GetMapping("/api/todo")
    public Iterable<TodoEntity> get() {
        return todoRepository.findAll();
    }
}
