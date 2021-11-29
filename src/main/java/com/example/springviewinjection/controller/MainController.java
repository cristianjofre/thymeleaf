package com.example.springviewinjection.controller;

import com.example.springviewinjection.model.Employee;
import com.example.springviewinjection.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public String irIndex(Model m){
        m.addAttribute("employee", new
                Employee());
        return "index";
    }

    @RequestMapping(value=("/save"), method= RequestMethod.POST)
    public String save(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/consulta";
    }

    @RequestMapping(value="/consulta", method= RequestMethod.GET)
    public String consulta(Model m){
        List<Employee> listaEmployee = employeeService.findAll();
        m.addAttribute("listaemployee", listaEmployee);
        return "consulta";
    }

    @RequestMapping(value="/dato/{id}", method = RequestMethod.POST)
    public String ingresaDato(@PathVariable(name="id") String id ){
        System.out.println(id);
        return "redirect:/index";
    }
}
