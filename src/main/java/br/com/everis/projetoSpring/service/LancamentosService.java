package br.com.everis.projetoSpring.service;

import br.com.everis.projetoSpring.model.Lancamentos;
import br.com.everis.projetoSpring.repository.LancamentosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LancamentosService {

    private final LancamentosRepository lancamentosRepository;

    public Lancamentos save (Lancamentos lancamentos){
         boolean categoriaExistente = validateCategoryById(lancamentos.getCategory().getId());
         if(!categoriaExistente){
             System.out.println("============== CATEGORIA NÃO EXISTE =============");
         }
        return lancamentosRepository.save(lancamentos);
    }

    public List<Lancamentos> findAll (Boolean paid) {
        List<Lancamentos> lancamentos = new ArrayList<>();
        if (Objects.isNull(paid)) {
            lancamentos = lancamentosRepository.findAll();
        } else {
            lancamentos = lancamentosRepository.findByPaid(paid);
        }
        return lancamentos;
    }

    public Optional<Lancamentos> findOne(Long id){
        return lancamentosRepository.findById(id);
    }

    public Lancamentos update (Long id, Lancamentos lancamentosUpdated){
        Lancamentos lancamentos= lancamentosRepository.findById(id).get();
        lancamentosUpdated.setId(lancamentos.getId());
        return lancamentosRepository.save(lancamentosUpdated);
    }

    public void delete(Long id){
        lancamentosRepository.deleteById(id);
    }

    public boolean validateCategoryById(Long idCategory){
      Optional<Lancamentos> lancamentos = lancamentosRepository.findById(idCategory);
        return lancamentos.isPresent();
    }

}
