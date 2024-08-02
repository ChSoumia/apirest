package com.chsoumia.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chsoumia.apirest.apirest.Entities.Producto;
import com.chsoumia.apirest.apirest.Repositories.IProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    // CRUD
    // INJECTAR UNA INSTANCIA DE REPOSITORIO
    @Autowired
    private IProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProducts() {
        return productoRepository.findAll();

    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NO se encontró el producto con el ID: " + id));
    }

    @PostMapping
    public Producto CreateProduct(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto UpdateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NO se encontró el producto con el ID: " + id));
        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deletProduct(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NO se encontró el producto con el ID: " + id));
        productoRepository.delete(producto);
        return "El producto con ID: " + id + " fue eliminado correctamente ";

    }

}
