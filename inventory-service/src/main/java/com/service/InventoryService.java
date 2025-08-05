package com.service;

import com.model.Inventory;
import com.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository repository;

    public List<Inventory> getAll() {
        return repository.findAll();
    }

    public Inventory getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Inventory getByProductId(Long productId) {
        return repository.findByProductId(productId).orElse(null);
    }

    public Inventory save(Inventory inv) {
        return repository.save(inv);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
