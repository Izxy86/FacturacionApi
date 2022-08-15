package com.coderhouse.rest.repository;

import com.coderhouse.rest.entity.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura,Long> {
}
