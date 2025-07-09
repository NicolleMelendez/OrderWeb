package com.order.orderweb.repository;

import com.order.orderweb.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicianRepository extends JpaRepository<Technician, Long>
{

}
