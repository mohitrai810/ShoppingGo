package com.Mohit.ecom_proj.service;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Mohit.ecom_proj.model.Product;
import com.Mohit.ecom_proj.repo.ProductRepo;

@Service
public class productService {
	@Autowired
	ProductRepo repo;
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
	
	public Product getProdById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(new Product());
	}

	
	public Product addProduct(Product product, MultipartFile image) throws IOException {
		product.setImageName(image.getOriginalFilename());
		product.setImageType(image.getContentType());
		product.setImageData(image.getBytes());
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
		product.setImageData(imageFile.getBytes());
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		return repo.save(product);
	}

	public void deleteProduct(int id) {
		repo.deleteById(id);
	}
	
	public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }

	
}
