package br.com.everis.projetoSpring.controller;

import br.com.everis.projetoSpring.model.Category;
import br.com.everis.projetoSpring.controller.dto.CategoryDTO;
import br.com.everis.projetoSpring.repository.CategoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Api (value = "TEST API CATEGORY")
@CrossOrigin (origins = "*")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @ApiOperation(value = "Cria uma categoria")
    @PostMapping("/categorias")
    public Category create (@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @ApiOperation(value = "Retorna uma lista de categoria")
    @GetMapping("/categorias")
    public List<Category> findAll (){
        return categoryRepository.findAll();
    }

    @GetMapping("/categorias/{id}")
    public Optional<Category> findOne(@PathVariable Long id){
        return categoryRepository.findById(id);
    }

    @PutMapping("/categorias/{id}")
    public Category update (@PathVariable Long id, @RequestBody Category categoryUpdated){
       Category category= categoryRepository.findById(id).get();
       categoryUpdated.setId(category.getId());
       return categoryRepository.save(categoryUpdated);
    }

    @DeleteMapping("/categorias/{id}")
    public void delete(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }

}
