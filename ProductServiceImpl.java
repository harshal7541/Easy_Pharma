package com.easypharma.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.easypharma.daos.ProductDao;
import com.easypharma.daos.ProductTypeDao;
import com.easypharma.entities.Product;
import com.easypharma.utils.StorageService;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao productDao;
	
	@Autowired
	private ProductTypeDao typeDao;

	@Autowired
	private StorageService storageService;
	
	@Override
	public List<Product> findAllProduct() {
		return productDao.findAll();
	}

	@Override
	public Product findProductById(int id) {
		Optional<Product> product=productDao.findById(id) ;
		return product.orElse(null);
	}
	
	

	@Override
	public void deleteById(int id) {
		productDao.deleteById(id);
		
	}

	@Override
	public Product save(Product product ,MultipartFile thumbnail) {
		String fileName = storageService.store(thumbnail);
		product.setThumbnail(fileName);
		return productDao.save(product);
	}

//	@Override
//	public List<Product> findProductByProductTypeId(int id) {
//		//return productDao.findProductByProductTypeId(id);
//		Optional<ProductType> type = typeDao.findById(id);
//		return productDao.findAllByProductType(type.orElse(null));
//	}

	
	@Override
	public Product update(Product product, MultipartFile thumbnail) {
		String fileName = storageService.store(thumbnail);
		product.setThumbnail(fileName);
		return productDao.save(product);
	}

	@Override
	public List<Product> findByProductName(String name) {
		return productDao.findByProductNameContaining(name);
	}

	@Override
	public Integer productCount() {
		return productDao.productCount();
	}

}