package org.ejercicio;
import org.ejercicio.models.Credit;
import org.ejercicio.service.Logica;
import org.ejercicio.dto.IdAmountDTO;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {
        Logica logica = Logica.getInstance();
        logica.generarPago(new IdAmountDTO(1, new BigDecimal(1000)));
    }
}