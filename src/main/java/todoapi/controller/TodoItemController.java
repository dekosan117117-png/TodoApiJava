package todoapi.controller;

import todoapi.dto.TodoItemRequest;
import todoapi.entity.TodoItem;
import todoapi.service.TodoItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoItemController {

    private final TodoItemService service;

    public TodoItemController(TodoItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoItem> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TodoItem create(@RequestBody TodoItemRequest request) {
        TodoItem item = new TodoItem();
        item.setTitle(request.getTitle());
        item.setCompleted(request.isCompleted());
        return service.create(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}