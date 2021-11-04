package br.com.everis.projetoSpring.controller;

import br.com.everis.projetoSpring.model.Lancamentos;
import br.com.everis.projetoSpring.controller.dto.LancamentosDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api (value = "TEST API LANÇAMENTOS")
@CrossOrigin (origins = "*")
public class LacamentosController {

    private final List<Lancamentos> lista = new ArrayList<>();

    @PostMapping("/lancamentos")
    public LancamentosDTO create(@RequestBody Lancamentos lancamentos){
        lista.add(lancamentos);
        return new LancamentosDTO(lista.indexOf(lancamentos));
    }

    @GetMapping("/lancamentos")
    public List<Lancamentos> read(){
        Comparator<Lancamentos> comparaPelaData = Comparator.comparing(Lancamentos::getDataLancamento);
        lista.sort(comparaPelaData);
        return lista;
    }

}
