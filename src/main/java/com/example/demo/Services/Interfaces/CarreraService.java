package com.example.demo.Services.Interfaces;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.DTO.CarreraDTO.CarreraInscriptosDTO;

import java.util.List;

public interface CarreraService {
    List<CarreraDTO> findAllCarreras();
    List<CarreraInscriptosDTO> findAllCarrerasInscriptos();
}
