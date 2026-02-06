package com.irvin.pos.dtos;

import java.util.List;

public class CategoryDTO {

    private Long id;
    private String name;
    private List<Long> productIDs;

    public CategoryDTO(){}
    public CategoryDTO(Long id, String name){
	this.id = id;
	this.name = name;
    }
    public CategoryDTO(CategoryDTO categoryDTO){
	id = categoryDTO.getId();
	name = categoryDTO.getName();
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Long> getProductIDs() {
		return productIDs;
	}
	public void setProductIDs(List<Long> productIDs) {
		this.productIDs = productIDs;
	}
}
