package br.com.everis.projetoSpring.controller;

import br.com.everis.projetoSpring.model.Category;
import br.com.everis.projetoSpring.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api (value = "TEST API CATEGORY")
@CrossOrigin (origins = "*")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(value = "Cria uma categoria")
    @PostMapping("/categorias")
    public ResponseEntity<?> create (@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(category));
    }

    @ApiOperation(value = "Retorna uma lista de categoria")
    @GetMapping("/categorias")
    public ResponseEntity<List<Category>> findAll (){
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
       Category category = categoryService.findById(id);
       return ResponseEntity.ok(category);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<?>  update (@PathVariable Long id, @RequestBody Category categoryUpdated){
       return ResponseEntity.ok(categoryService.update(id,categoryUpdated));
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
