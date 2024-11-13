package com.Mohit.ecom_proj.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Mohit.ecom_proj.model.Product;
import com.Mohit.ecom_proj.service.productService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {
	@Autowired
	productService service; 
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<>(service.getAllProduct(),HttpStatus.OK);
		
	}
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProdById(id);
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart("product") String productJson, @RequestPart("image") MultipartFile image) {
	    try {
	        // Parse the product JSON into the Product object
	        ObjectMapper objectMapper = new ObjectMapper();
	        Product product = objectMapper.readValue(productJson, Product.class);

	        // Continue as before
	        Product product1 = service.addProduct(product, image);
	        return new ResponseEntity<>(product1, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
	  Product product = service.getProdById(productId);
	  byte[] imageFile = product.getImageData();

	  return ResponseEntity.ok()
	      .contentType(MediaType.valueOf(product.getImageType()))
	      .body(imageFile);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
	    Product product1;
		try {
			product1 = service.updateProduct(id, product, imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
		}
	    if (product1 != null) {
	        return new ResponseEntity<>("Updated", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
	    }
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		Product product = service.getProdById(id);
		if (product!=null){
			service.deleteProduct(id);
			return new ResponseEntity<>("Deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {

        List<Product> products = service.searchProducts(keyword);
        System.out.println("searching with " + keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
	
	
	
}
