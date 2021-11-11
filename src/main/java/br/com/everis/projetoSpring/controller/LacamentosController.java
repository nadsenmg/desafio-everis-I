package br.com.everis.projetoSpring.controller;

import br.com.everis.projetoSpring.model.Lancamentos;
import br.com.everis.projetoSpring.repository.LancamentosRepository;
import br.com.everis.projetoSpring.service.CategoryService;
import br.com.everis.projetoSpring.service.LancamentosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.*;

@RestController
@Api (value = "TEST API LANÇAMENTOS")
@CrossOrigin (origins = "*")
@RequiredArgsConstructor
public class LacamentosController {

    private final LancamentosService lancamentosService;
    private final CategoryService categoryService;

    @ApiOperation(value = "Cria uma lançamento")
    @PostMapping("/lancamentos")
    public ResponseEntity<?> create (@RequestBody Lancamentos lancamentos){
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentosService.save(lancamentos));
    }

    @ApiOperation(value = "Retorna uma lista de lançamentos")
    @GetMapping("/lancamentos")
    public ResponseEntity<List<Lancamentos>> findAll (@RequestParam(value = "paid", required = false) Boolean paid){
      List<Lancamentos> lancamentos = lancamentosService.findAll(paid);
      return ResponseEntity.ok(lancamentos);
    }

    @ApiOperation(value = "Retorna um lançamento")
    @GetMapping("/lancamentos/{categoryName}")
    public ResponseEntity<Long> findOne(@PathVariable String categoryName){
        Long category = categoryService.findByName(categoryName);
        return ResponseEntity.ok(category);
    }

    @ApiOperation(value = "Atualiza um lançamento")
    @PutMapping("/lancamentos/{id}")
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody Lancamentos lancamentosUpdated){
       Lancamentos lancamentos = lancamentosService.save(lancamentosUpdated);
       return ResponseEntity.ok(lancamentos);
    }

    @ApiOperation(value = "Deleta um lançamento")
    @DeleteMapping("/lancamentos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
       lancamentosService.delete(id);
       return ResponseEntity.noContent().build();
    }


}
