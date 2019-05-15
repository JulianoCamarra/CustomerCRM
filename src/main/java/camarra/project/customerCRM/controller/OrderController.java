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

import camarra.project.customerCRM.entity.CustomerOrder;
import camarra.project.customerCRM.entity.Product;
import camarra.project.customerCRM.service.CRMService;

@Controller
@RequestMapping("employee")
public class OrderController {

	@Autowired
	private CRMService service;

	@GetMapping("orders")
	public String orderPage(Model theModel) {

		List<CustomerOrder> theOrders = service.getCustomerOrders();

		theModel.addAttribute("orders", theOrders);

		return "orders";
	}

	@PostMapping("orders/saveOrder")
	public String saveOrder(@ModelAttribute("order") CustomerOrder theOrder) {

		System.out.println(theOrder.getCustomer());
		System.out.println(theOrder.getProductId());
		Product selectedProduct = service.getProduct(theOrder.getProductId());
		theOrder.setProduct(selectedProduct);
		
		service.saveCustomerOrder(theOrder);

		return "redirect:/employee/orders";
	}
	
	@GetMapping("orders/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int customerId, Model theModel) {
		
		CustomerOrder theOrder= service.getCustomerOrder(customerId);
		List<Product> theProducts= service.getProducts();
		
		//Remove the product in the current order from the list, so that it is not iterated twice in the product dropdown
		theProducts.remove(theOrder.getProduct());
		
		theModel.addAttribute("order", theOrder);
		theModel.addAttribute("products", theProducts);
		
		return "order-form";
	}

	@GetMapping("orders/showFormForAdd")
	public String addOrderToCustomer(@RequestParam("id") int customerId, Model theModel) {

		CustomerOrder newOrder = new CustomerOrder();
		newOrder.setCustomer(service.getCustomer(customerId));

		List<Product> theProducts = service.getProducts();

		theModel.addAttribute("order", newOrder);
		theModel.addAttribute("products", theProducts);
		return "order-form";
	}
	
	@GetMapping("orders/deleteOrder")
	public String deleteOrder(@RequestParam("id") int orderId) {
		
		service.deleteCustomerOrder(orderId);
		
		return "redirect:/employee/orders";
		
	}
	
	
}
