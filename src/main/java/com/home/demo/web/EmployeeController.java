package com.home.demo.web;

import com.home.demo.exception.RecordNotFoundException;
import com.home.demo.model.EmployeeEntity;
import com.home.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public String getAllEmployees(Model model) {
        List<EmployeeEntity>list = service.getAllEmployees();

        model.addAttribute("employees", list);
        return "list-employees";
    }

    @GetMapping({"/edit", "/edit/{id}"})
    public String editEmployeeById(@PathVariable("id") Optional<Long> id, Model model)
            throws RecordNotFoundException {
        if (id.isPresent()) {
            EmployeeEntity entity = service.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
        } else {
            model.addAttribute("employee", new EmployeeEntity());
        }
        return "add-edit-employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id, Model model)
            throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }

    @PostMapping("/createEmployee")
    public String createOrUpdateEmployee(EmployeeEntity employee) {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }
}
