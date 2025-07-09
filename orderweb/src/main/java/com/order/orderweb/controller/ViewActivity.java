package com.order.orderweb.controller;

import com.order.orderweb.model.Activity;
import com.order.orderweb.repository.ActivityRepository;
import com.order.orderweb.repository.TechnicianRepository;
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
public class ViewActivity {
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    TechnicianRepository technicianRepository;
    @Autowired
    TypeActivityRepository typeActivityRepository;

    @GetMapping("/vista/activity")
    public String Lista(Model model)
    {
        model.addAttribute("activity", activityRepository.findAll ());
        return "activity";
    }

    @GetMapping("vistaA/form")
    public String form(Model model)
    {
        model.addAttribute("activity", new Activity ());
        model.addAttribute("technician", technicianRepository.findAll ());
        model.addAttribute("typeActivity", typeActivityRepository.findAll ());
        return "activity_form";
    }

    @PostMapping("/vistaA/save")
    public String save(@ModelAttribute Activity activity, RedirectAttributes ra)
    {
        activityRepository.save ( activity );
        ra.addFlashAttribute("success", "Activity Saved");
        return "redirect:/vista/activity";
    }

    @GetMapping("/vistaA/edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        Activity activity = activityRepository.findById ( id ).orElse ( null );
        model.addAttribute("activity", activity);
        return "activity_form";
    }

    @PostMapping("/vistaA/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        activityRepository.deleteById ( id );
        ra.addFlashAttribute("success", "Activity Deleted");
        return "redirect:/vista/activity";
    }



}
