package RentingApp.RentEasy.controller;

import RentingApp.RentEasy.Rentservice.ProductService;
import RentingApp.RentEasy.entity.PostForProduct;
import RentingApp.RentEasy.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private ProductService service;

    @Autowired
    public Controller(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<ProductDetails> findall() {
        return service.findall();
    }

    @GetMapping("/productdetails/{id}")
    public ProductDetails findById(@PathVariable int id) {
        ProductDetails getProductById = service.findById(id);
        if (getProductById == null) {
            throw new RuntimeException("Employee not found");
        }
        return getProductById;
    }


    @PostMapping("/upload")
    public ProductDetails save(@RequestBody ProductDetails productForSave) {

        service.save(productForSave);
        return productForSave;
    }

    @DeleteMapping("/delete")
    public void delete(ProductDetails id) {
        service.delete(id);
    }

    @PostMapping("/postforproduct")
    public PostForProduct RequestForProduct(@RequestBody PostForProduct RequestProducts) {
        service.saves(RequestProducts);
        return RequestProducts;
    }

    @GetMapping("/posts")
    public List<PostForProduct> findallPost() {
        return service.findallPost();
    }
}
