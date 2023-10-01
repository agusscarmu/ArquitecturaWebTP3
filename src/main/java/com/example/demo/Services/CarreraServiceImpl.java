package com.example.demo.Services;

import com.example.demo.DTO.CarreraDTO.CarreraDTO;
import com.example.demo.DTO.CarreraDTO.CarreraInscriptosDTO;
import com.example.demo.Repositories.CarreraRepository;
import com.example.demo.Services.Interfaces.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    CarreraRepository cr;

    @Override
    public List<CarreraDTO> findAllCarreras() {
        return cr.findAllCarreras();
    }

    @Override
    public List<CarreraInscriptosDTO> findAllCarrerasInscriptos() {
        return cr.findCarrerasInscriptos();
    }
}
