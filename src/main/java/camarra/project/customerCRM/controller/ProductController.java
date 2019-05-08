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

import camarra.project.customerCRM.entity.Product;
import camarra.project.customerCRM.service.CRMService;

@Controller
@RequestMapping("employee/")
public class ProductController {

	@Autowired
	CRMService service;

	@GetMapping("/products")
	public String productsPage(Model theModel) {
		List<Product> theProducts = service.getProducts();

		theModel.addAttribute("products", theProducts);
		// theModel.addAttribute("entityList", theProducts);

		return "product";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		service.saveProduct(theProduct);
		
		return "redirect:/employee/products";

	}

	@GetMapping("/product/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Product theProduct = new Product();
		theModel.addAttribute("product", theProduct);
		
		return "product-form";

	}
	
	@GetMapping("/products/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
		
		Product theProduct= service.getProduct(theId);
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
		
		@GetMapping("/products/delete")
		public String deleteProduct(@RequestParam("id") int theId) {
			
			service.deleteProduct(theId);
			
			return "redirect:/employee/products";
		}
	
}
