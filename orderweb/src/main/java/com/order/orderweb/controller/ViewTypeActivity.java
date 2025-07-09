package com.order.orderweb.controller;

import com.order.orderweb.model.Activity;
import com.order.orderweb.model.TypeActivity;
import com.order.orderweb.repository.TypeActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ViewTypeActivity {
    @Autowired
    TypeActivityRepository typeActivityRepository;



    @GetMapping("/vista/typeActivity")
    public String Lista(Model model)
    {
        model.addAttribute("typeActivity", typeActivityRepository.findAll ());
        return "typeActivity";
    }

    @GetMapping("vistaTA/form")
    public String form(Model model)
    {
        model.addAttribute("typeActivity", new Activity ());
        return "typeActivity_form";
    }

    @PostMapping("/vistaTA/save")
    public String save(@ModelAttribute TypeActivity typeActivity, RedirectAttributes ra)
    {
        typeActivityRepository.save ( typeActivity );
        ra.addFlashAttribute("success", "Type Activity Saved");
        return "redirect:/vista/typeActivity";
    }

    @GetMapping("/vistaTA/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        TypeActivity typeActivity = typeActivityRepository.findById ( id ).orElse ( null );
        model.addAttribute("typeActivity", typeActivity);
        return "typeActivity_form";
    }

    @PostMapping("/vistaTA/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        typeActivityRepository.deleteById ( id );
        ra.addFlashAttribute("success", "Type Activity Deleted");
        return "redirect:/vista/typeActivity";
    }


}
