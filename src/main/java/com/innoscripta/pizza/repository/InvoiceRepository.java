package com.innoscripta.pizza.repository;

import com.innoscripta.pizza.entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, UUID> {
}
