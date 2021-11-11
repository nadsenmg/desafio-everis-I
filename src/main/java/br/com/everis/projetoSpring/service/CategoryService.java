package br.com.everis.projetoSpring.service;

import br.com.everis.projetoSpring.model.Category;
import br.com.everis.projetoSpring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category save (Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
      return categoryRepository.findAll();
    }

    public Long findByName(String nameCategory){
        Category category = categoryRepository.findByName(nameCategory);
        return category.getId();
    }

    public Category findById(Long id) {
       return categoryRepository.findById(id).get();
    }

    public Category update(Long id, Category categoryUpdated){
        Category category = categoryRepository.findById(id).get();
        categoryUpdated.setId(category.getId());
        return categoryRepository.save(categoryUpdated);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}
