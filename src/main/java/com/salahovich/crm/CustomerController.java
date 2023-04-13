package com.salahovich.crm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping({"/list", "/"})
    public String listCustomers(Model theModel){
        List<Customer> list = customerService.getCustomers();
        theModel.addAttribute("customers", list);
        
        return "list-customers";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(HttpServletRequest request, Model theModel){
        String firstName =  request.getParameter("firstName");
        String lastName =  request.getParameter("lastName");
        String email =  request.getParameter("email");
        Customer temp = new Customer(firstName, lastName, email);
        customerService.addCustomer(temp);
        
        return "redirect:/customer/list";
    }

    @GetMapping("/showForm")
    public String showForm(){
        return "add-customer";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(HttpServletRequest request, Model theModel){
        int id = Integer.parseInt((String) request.getParameter("customerId"));
        Customer temp = customerService.getCustomer(id);
        theModel.addAttribute("customer", temp);
        return "update-customer";
    }

    @PostMapping("/updateCustomer")
    public String updateCustomer(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName =  request.getParameter("firstName");
        String lastName =  request.getParameter("lastName");
        String email =  request.getParameter("email");
        
        Customer temp = new Customer(firstName, lastName, email);
        temp.setId(id);
        customerService.updateCustomer(temp);
        
        return "redirect:/customer/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") String theId){
        int id = Integer.parseInt(theId);
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
