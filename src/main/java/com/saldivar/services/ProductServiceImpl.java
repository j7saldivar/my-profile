package com.saldivar.services;

import org.springframework.stereotype.Service;

import com.saldivar.domains.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private Product p;
	
	public ProductServiceImpl () {
		Product product = new Product();
		product.setId(1);
		product.setName("Product name");
		p = product;
	}
	
	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return p;
	}

}
