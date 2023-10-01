package com.example.demo.Sort;

import com.example.demo.DTO.InscripcionDTO.InscripcionesPorAnioDTO;

import java.util.Comparator;

public class OrderByNameYear implements Comparator<InscripcionesPorAnioDTO> {

    private final Comparator<InscripcionesPorAnioDTO> c1;
    private final Comparator<InscripcionesPorAnioDTO> c2;

    public OrderByNameYear() {
        this.c1 = new OrderByName();
        this.c2 = new OrderByYear();
    }


    @Override
    public int compare(InscripcionesPorAnioDTO o1, InscripcionesPorAnioDTO o2) {
        int r = c1.compare(o1,o2);
        if(r!=0){
            return r;
        }else{
            return c2.compare(o1,o2);
        }
    }
}
