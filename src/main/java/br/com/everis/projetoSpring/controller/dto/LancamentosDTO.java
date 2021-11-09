package br.com.everis.projetoSpring.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentosDTO {

    private Long id;
    private String name;
    private String description;
    private String type;
    private String amount;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;
    private boolean paid;
    private Long categoryId;
}
