package com.easypharma.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.easypharma.daos.ProductTypeDao;
import com.easypharma.entities.ProductType;
import com.easypharma.utils.StorageService;

@Transactional
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	ProductTypeDao productTypeDao;

	@Autowired
	private StorageService storageService;

	@Override
	public ProductType findProductTypeById(int id) {

		return productTypeDao.getById(id);
	}

	@Override
	public boolean deleteProductTypeById(int id) {
		if (productTypeDao.existsById(id)) {
			productTypeDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<ProductType> findProductTypeAll() {

		return productTypeDao.findAll();
	}

	@Override
	public ProductType saveProductType(ProductType productType, MultipartFile thumbnail) {
		String fileName = storageService.store(thumbnail);
		productType.setTypeThumbnail(fileName);
		return productTypeDao.save(productType);

	}
}