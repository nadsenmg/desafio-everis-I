package br.com.everis.projetoSpring.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lancamentos {

        private String name;
        private String description;
        private String type;
        private String amount;
        private String date;
        @JsonFormat(pattern = "dd/MM/yyyy")
        private LocalDate dataLancamento;
        private boolean paid;
        private long categoryId;
}
