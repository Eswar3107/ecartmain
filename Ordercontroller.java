package eStoreProduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eStoreProduct.DAO.OrderDAO;
import eStoreProduct.model.Orders;
import eStoreProduct.model.Product;
@Controller
public class Ordercontroller {
	
	@Autowired
	 private OrderDAO orderdao;
	
	  @RequestMapping("/order")
	  public String showOrders(Model model) {
		  System.out.println("inshow");
	    List<Orders> orderProducts = orderdao. getorderProds();
	    model.addAttribute("orderProducts", orderProducts);
	    return "Orders";
	  }

}
