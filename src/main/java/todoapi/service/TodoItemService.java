package todoapi.service;

import todoapi.entity.TodoItem;
import todoapi.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItemService(TodoItemRepository repository) {
        this.repository = repository;
    }

    public List<TodoItem> getAll() {
        return repository.findAll();
    }

    public TodoItem create(TodoItem item) {
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}