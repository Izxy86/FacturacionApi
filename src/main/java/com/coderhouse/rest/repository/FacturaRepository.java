package com.coderhouse.rest.repository;

import com.coderhouse.rest.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
}
