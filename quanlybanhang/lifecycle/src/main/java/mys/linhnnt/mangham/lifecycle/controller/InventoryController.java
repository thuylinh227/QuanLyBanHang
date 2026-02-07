package mys.linhnnt.mangham.lifecycle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mys.linhnnt.mangham.lifecycle.dto.InventoryDTO;
import mys.linhnnt.mangham.lifecycle.entity.Inventory;
import mys.linhnnt.mangham.lifecycle.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public ResponseEntity<Inventory> save(@RequestBody InventoryDTO dto) {
        return ResponseEntity.ok(inventoryService.saveOrUpdate(dto));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> get(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.getByProductId(productId));
    }
}
