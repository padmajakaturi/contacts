package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.contactmodel;
import com.example.demo.service.contactservice;

@Controller
@RequestMapping("/contacts")
public class contactcontroller {

    @Autowired
    private contactservice service;

    @GetMapping
    public String getAllContacts(Model m) {
        m.addAttribute("contacts", service.getall());
        return "contacts";
    }

    @GetMapping("/addcontact")
    public String formReset(Model m) {
        m.addAttribute("contact", new contactmodel());
        return "add_contact";
    }

    @PostMapping("/save")
    public String savecontact(@ModelAttribute("contact") contactmodel u)
    {
        service.addContact(u);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "redirect:/contacts";
    }

    @PostMapping("/update/{id}")
    public String updateContact(@PathVariable("id") long id, @ModelAttribute("contact") contactmodel u) {
        u.setId(id);
        service.addContact(u);
        return "redirect:/contacts";
    }

    @GetMapping("/edit_contact/{id}")
	public String editform(@PathVariable("id") long id,Model m) {
		m.addAttribute("contact",service.getById(id));
		return "edit_contact";
		
	}
}
