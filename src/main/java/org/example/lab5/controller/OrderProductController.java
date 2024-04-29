package org.example.lab5.controller;

import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.example.lab5.models.OrderProduct;
import org.example.lab5.models.Person;
import org.example.lab5.models.Product;
import org.example.lab5.services.impl.OrderService;
import org.example.lab5.services.impl.PersonService;
import org.example.lab5.services.impl.ProductService;
import org.example.lab5.utils.ConvertToJson;
import org.example.lab5.utils.Email;
import org.example.lab5.utils.EncodeDecodeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class OrderProductController     {
    @Autowired
    private OrderService ops;
    @Autowired
    private PersonService personService;
    @Autowired
    private ProductService productService;


    @GetMapping
    public ModelAndView directToIndex() {
        ModelAndView mav = new ModelAndView("order");
        System.out.println(productService.findAll());
        mav.addObject("products", productService.findAll());
        return mav;
    }

    @PostMapping("/order")
    public ModelAndView makeOrder(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("order");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String productID = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        Person person = personService.findByEmail(email).orElse(null);
        if (person == null){

            person = new Person(name, gender, address, phone,email);

            personService.save(person);
        }

        Product product = productService.findById(Long.parseLong(productID));
        if(product.getQuantity() - Integer.parseInt(quantity) < 0){
            mav.addObject("products", productService.findAll());
            mav.addObject("status", "F");
            return mav;
        }
        product.setQuantity(product.getQuantity() - Integer.parseInt(quantity));
        OrderProduct op = new OrderProduct(LocalDate.now().toString(), Double.parseDouble(quantity), product, person);

        productService.update(product);

        ops.save(op);


        String textEncode = EncodeDecodeMessage.encodeMessage(ConvertToJson.convertObjectToJson(op));





        mav.addObject("products", productService.findAll());
        mav.addObject("status", "S");
        Email emailSender = new Email();
        emailSender.sendMess(email, textEncode);
        return mav;
    }
}
