package com.order.orderweb.controller;


import com.order.orderweb.model.Technician;
import com.order.orderweb.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technician")
public class ControllerTechnician {
    @Autowired
    private TechnicianRepository technicianRepository;

    @GetMapping
    public List<Technician> getAll()
    {
        return technicianRepository.findAll ();
    }

    @GetMapping("/{id}")
    public Technician getByID(@PathVariable Long id)
    {
        return technicianRepository.findById(id).orElse(null  );
    }

    @PostMapping
    public Technician create(@RequestBody Technician technician)
    {
        return technicianRepository.save ( technician );
    }

    @PutMapping("/{id}")
    public Technician update(@PathVariable Long id, @RequestBody Technician technician)
    {
        technician.setId ( id );
        return technicianRepository.save ( technician );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        technicianRepository.deleteById ( id );
    }


}
