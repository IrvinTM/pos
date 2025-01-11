package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.irvin.pos.entities.Category;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCategory(Category category) throws PropertyAlreadyExistException{
        if (categoryRepository.findByName(category.getName())!= null) {
            throw new PropertyAlreadyExistException("name", category.getName());
        }
            return categoryRepository.save(category);
    }
    //TODO proper pagination
    public Page<Category> getAllCategories(){
        return categoryRepository.findAll(PageRequest.of(0, 10));
    }

    //TODO create a proper exception
    public Category updateCategorie(Category category){
        if (categoryRepository.findById(category.getId()) != null) {
            throw new IllegalStateException("Product doesnt exist");
        }
        return categoryRepository.save(category);
    }

    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }

}
