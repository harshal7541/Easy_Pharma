package com.easypharma.dtos;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.easypharma.entities.ProductType;

public class ProductTypeInDTO {
	private int productTypeId;
	private String productTypeName;
	private MultipartFile typeThumbnail;
	public ProductTypeInDTO()
	{
		
	}

	public ProductTypeInDTO(int productTypeId, String productTypeName, MultipartFile typeThumbnail) {
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.typeThumbnail = typeThumbnail;
	}
	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public MultipartFile getTypeThumbnail() {
		return typeThumbnail;
	}

	public void setTypeThumbnail(MultipartFile typeThumbnail) {
		this.typeThumbnail = typeThumbnail;
	}
	

	@Override
	public String toString() {
		return "ProductTypeInDTO [productTypeId=" + productTypeId + ", productTypeName=" + productTypeName
				+ ", typeThumbnail=" + typeThumbnail + "]";
	}

	public static ProductType toEntity(ProductTypeInDTO dto) {
		ProductType productType = new ProductType();
		BeanUtils.copyProperties(dto, productType, "thumbnail");
		productType.setProductTypeName(dto.getProductTypeName());
		return productType;
	}

}