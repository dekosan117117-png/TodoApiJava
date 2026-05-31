package todoapi.service;

import todoapi.dto.TodoItemRequest;
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

    public TodoItem update(Long id, TodoItemRequest request) {
        TodoItem item = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found"));
        item.setTitle(request.getTitle());
        item.setCompleted(request.isCompleted());
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}