package br.com.everis.projetoSpring.controller;

import br.com.everis.projetoSpring.model.Category;
import br.com.everis.projetoSpring.controller.dto.CategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api (value = "TEST API CATEGORY")
@CrossOrigin (origins = "*")
public class CategoryController {

    private final List<Category> list = new ArrayList<>();

    @ApiOperation(value = "Cria uma categoria")
    @PostMapping("/categorias")
    public CategoryDTO create (@RequestBody Category category){
        list.add(category);
        return new CategoryDTO(list.indexOf(category));
    }

    @ApiOperation(value = "Retorna uma lista de categoria")
    @GetMapping("/categorias")
    public List<Category> read (Category category){
        return list;
    }

}
