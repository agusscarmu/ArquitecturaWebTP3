package com.example.demo.Sort;

import com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO;

import java.util.Comparator;

public class OrderByYear implements Comparator<InscripcionesPorAnioDTO> {
    @Override
    public int compare(InscripcionesPorAnioDTO o1, InscripcionesPorAnioDTO o2) {
        return o1.getAnio()-o2.getAnio();
    }
}
