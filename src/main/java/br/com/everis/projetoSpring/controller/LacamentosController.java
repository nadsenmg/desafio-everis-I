package br.com.everis.projetoSpring.controller;

import br.com.everis.projetoSpring.model.Lancamentos;
import br.com.everis.projetoSpring.repository.LancamentosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api (value = "TEST API LANÇAMENTOS")
@CrossOrigin (origins = "*")
@RequiredArgsConstructor
public class LacamentosController {

    private final LancamentosRepository lancamentosRepository;

    @ApiOperation(value = "Cria uma lançamento")
    @PostMapping("/lancamentos")
    public Lancamentos create (@RequestBody Lancamentos lancamentos){
        Optional<Lancamentos> lancamentosFound = Optional.ofNullable
                (lancamentosRepository.findByCategoryId(lancamentos.getCategory().getId()));
       if(lancamentosFound.isEmpty()){
           System.out.println("ERROR");
       }
        return lancamentosRepository.save(lancamentos);
    }

    @ApiOperation(value = "Retorna uma lista de lançamentos")
    @GetMapping("/lancamentos")
        public List<Lancamentos> findAll (@RequestParam(value = "paid", required = false) Boolean paid){
        List<Lancamentos> lancamentos = new ArrayList<>();
        if (Objects.isNull(paid)) {
            lancamentos = lancamentosRepository.findAll();
        } else {
            lancamentos = lancamentosRepository.findByPaid(paid);
        }
        return lancamentos;

    }

    @ApiOperation(value = "Retorna um lançamento")
    @GetMapping("/lancamentos/{id}")
    public Optional<Lancamentos> findOne(@PathVariable Long id){
        return lancamentosRepository.findById(id);
    }

    @ApiOperation(value = "Atualiza um lançamento")
    @PutMapping("/lancamentos/{id}")
    public Lancamentos update (@PathVariable Long id, @RequestBody Lancamentos lancamentosUpdated){
        Lancamentos lancamentos= lancamentosRepository.findById(id).get();
        lancamentosUpdated.setId(lancamentos.getId());
        return lancamentosRepository.save(lancamentosUpdated);
    }

    @ApiOperation(value = "Deleta um lançamento")
    @DeleteMapping("/lancamentos/{id}")
    public void delete(@PathVariable Long id){
        lancamentosRepository.deleteById(id);
    }

}
