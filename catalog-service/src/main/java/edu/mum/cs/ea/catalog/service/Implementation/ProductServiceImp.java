package edu.mum.cs.ea.catalog.service.Implementation;

import edu.mum.cs.ea.catalog.model.Product;
import edu.mum.cs.ea.catalog.repository.ProductRepository;
import edu.mum.cs.ea.catalog.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).get();
    }

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
}
