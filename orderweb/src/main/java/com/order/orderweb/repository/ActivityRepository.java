package com.order.orderweb.repository;

import com.order.orderweb.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long>
{

}
