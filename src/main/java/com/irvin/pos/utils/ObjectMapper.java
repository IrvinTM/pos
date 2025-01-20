package com.irvin.pos.utils;

import java.util.ArrayList;
import java.util.List;

import com.irvin.pos.dtos.CategoryDTO;
import com.irvin.pos.dtos.ProductDTO;
import com.irvin.pos.dtos.TaxDTO;
import com.irvin.pos.entities.Category;
import com.irvin.pos.entities.Product;
import com.irvin.pos.entities.Tax;

public class ObjectMapper {

    public static Product dtoToProduct(ProductDTO productDTO, List<Category> categories, List<Tax> taxes) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCode(productDTO.getCode());
        product.setBarCode(productDTO.getBarCode());
        product.setMeasurementUnit(productDTO.getMeasurementUnit());
        product.setCategories(categories);
        product.setActive(productDTO.isActive());
        product.setAgeRestricted(productDTO.isAgeRestricted());
        product.setDescription(productDTO.getDescription());
        product.setImage(productDTO.getImage());
        product.setCost(productDTO.getCost());
        product.setTaxes(taxes);
        product.setPriceIncludesTaxes(productDTO.isPriceIncludesTaxes());
        product.setAllowPriceChange(productDTO.isAllowPriceChange());
        product.setNoTaxIncludedPrice(productDTO.getNoTaxIncludedPrice());
        product.setProfitMargin(productDTO.getProfitMargin());
        product.setSalesPrice(productDTO.getSalesPrice());
        return product;
    }

    public static ProductDTO productToDTO(Product product){
        List<Long> categories = new ArrayList<>();
        product.getCategories().forEach((category) -> categories.add(category.getId()));

        List<Long> taxes = new ArrayList<>();
        product.getTaxes().forEach(tax -> taxes.add(tax.getId()));

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCode(product.getCode());
        productDTO.setBarCode(product.getBarCode());
        productDTO.setMeasurementUnit(product.getMeasurementUnit());
        productDTO.setCategories(categories);
        productDTO.setActive(product.isActive());
        productDTO.setAgeRestricted(product.isAgeRestricted());
        productDTO.setDescription(product.getDescription());
        productDTO.setImage(product.getImage());
        productDTO.setCost(product.getCost());
        productDTO.setTaxes(taxes);
        productDTO.setPriceIncludesTaxes(product.priceIncludesTaxes());
        productDTO.setAllowPriceChange(product.allowPriceChange());
        productDTO.setNoTaxIncludedPrice(product.getNoTaxIncludedPrice());
        productDTO.setProfitMargin(product.getProfitMargin());
        productDTO.setSalesPrice(product.getSalesPrice());
        return productDTO;
    }

    public static TaxDTO taxToDTO(Tax tax){
        TaxDTO dto = new TaxDTO();
        dto.setId(tax.getId());
        dto.setName(tax.getName());
        dto.setCode(tax.getCode());
        dto.setPercentage(tax.getPercentage());
        return dto;
    }
    public static Tax dtoToTax(TaxDTO taxDTO, Tax tax){
        tax.setName(taxDTO.getName());
        tax.setCode(taxDTO.getCode());
        tax.setPercentage(taxDTO.getPercentage());
        return tax;
    }
    
    public static CategoryDTO categoryToDTO(Category category){
    return new CategoryDTO(category.getId(), category.getName());
    }
    public  static Category dtoToCategory(CategoryDTO categoryDTO){
        //TODO may need to add the list of products  List<long> productsIds
        return new Category(categoryDTO.getId(), categoryDTO.getName());
    }
}
