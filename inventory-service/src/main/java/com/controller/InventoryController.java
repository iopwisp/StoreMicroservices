package com.controller;

import com.model.Inventory;
import com.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService service;

    @GetMapping
    public List<Inventory> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Inventory get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/product/{productId}")
    public Inventory byProduct(@PathVariable Long productId) {
        return service.getByProductId(productId);
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inv) {
        return service.save(inv);
    }

    @PutMapping("/{id}")
    public Inventory update(@PathVariable Long id, @RequestBody Inventory inv) {
        inv.setId(id);
        return service.save(inv);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
