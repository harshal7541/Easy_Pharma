package com.easypharma.dtos;

import org.springframework.beans.BeanUtils;

import com.easypharma.entities.ProductType;

public class ProductTypeDTO {
	private int ProductTypeId;
	private String productTypeName;
	private String typeThumbnail;

	public ProductTypeDTO()
	{
		
	}

	public ProductTypeDTO(int productTypeId, String productTypeName, String typeThumbnail) {
		ProductTypeId = productTypeId;
		this.productTypeName = productTypeName;
		this.typeThumbnail = typeThumbnail;
	}

	public int getProductTypeId() {
		return ProductTypeId;
	}



	public void setProductTypeId(int productTypeId) {
		ProductTypeId = productTypeId;
	}



	public String getProducttypeName() {
		return productTypeName;
	}



	public void setProducttypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}



	public String getTypeThumbnail() {
		return typeThumbnail;
	}



	public void setTypeThumbnail(String typeThumbnail) {
		this.typeThumbnail = typeThumbnail;
	}


	@Override
	public String toString() {
		return "ProductTypeDTO [ProductTypeId=" + ProductTypeId + ", productTypeName=" + productTypeName
				+ ", typeThumbnail=" + typeThumbnail + "]";
	}



	public static ProductTypeDTO fromEntity(ProductType type) {
		ProductTypeDTO dto = new ProductTypeDTO();
		BeanUtils.copyProperties(type, dto);
		dto.setProducttypeName(type.getProductTypeName());
		return dto;
	}

}