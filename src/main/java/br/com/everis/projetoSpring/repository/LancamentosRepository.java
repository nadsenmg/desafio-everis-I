package br.com.everis.projetoSpring.repository;

import br.com.everis.projetoSpring.model.Category;
import br.com.everis.projetoSpring.model.Lancamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentosRepository extends JpaRepository<Lancamentos, Long>{
    Lancamentos findByCategoryId(long categoryId);
    List<Lancamentos> findByPaid(Boolean paid);
}
