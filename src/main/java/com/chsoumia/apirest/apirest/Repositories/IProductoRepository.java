package com.chsoumia.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chsoumia.apirest.apirest.Entities.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
