package camarra.project.customerCRM.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import camarra.project.customerCRM.entity.Customer;
import camarra.project.customerCRM.entity.CustomerOrder;
import camarra.project.customerCRM.entity.TotalPriceView;
import camarra.project.customerCRM.service.CRMService;

@Controller
@RequestMapping("employee/")
public class CustomerController {

	@Autowired
	private CRMService service;

	@GetMapping(value= {"/customers","localhost:8080/"})
	public String customerPage(Model theModel) {
		List<Customer> theCustomers = service.getCustomers();

		for (Customer c : theCustomers) {
			System.out.println(c.getOrders());
		}

		theModel.addAttribute("customers", theCustomers);

		// System.out.println("hi");
		// theModel.addAttribute("entityList",theCustomers);

		/*
		 * TWO Ways to get a customer's orders. Way #1: Call a customer, then make a
		 * list of CustomerOrders that calls customer.getOrders();
		 * 
		 * Customer c= repository.getCustomerOrders(1); List<CustomerOrder> orders=
		 * c.getOrders(); theModel.addAttribute("orders",orders);
		 */

		// Way #2: Make a direct call to CustomerOrder where customer.id= the customer
		// ID passed through parameter

		return "customer";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		service.saveCustomer(theCustomer);

		return "redirect:/employee/customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {

		Customer theCustomer = service.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("id") int theId) {

		service.deleteCustomer(theId);

		return "redirect:/employee/customers";

	}

	@GetMapping("/showCustomerOrders")
	public String customerOrders(@RequestParam("id") int theId, Model theModel) {

		Customer theCustomer = service.getCustomer(theId);
		List<CustomerOrder> orders= theCustomer.getOrders();
		
		theModel.addAttribute("orders", orders);
		theModel.addAttribute("customer", theCustomer);

		
		TotalPriceView totalPrice= service.getCustomerTotalPrice(theId);
		theModel.addAttribute("totalPrice", totalPrice);

		return "orders";

	}
	
	
}
