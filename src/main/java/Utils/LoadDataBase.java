package Utils;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repositories.EstudianteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDataBase {
//    CommandLineRunner initDataBase(@Qualifier("EstudianteRepository")EstudianteRepository er){
//        return args -> {
//            log.info("Preloading "+ er.save(new Estudiante(41724302, 820, "Agustin", "Carmusciano", 24, "Masculino", "Olavarria")));
//            log.info("Preloading "+ er.save(new Estudiante(41727777, 810, "Lucas", "Carmusciano", 21, "Masculino", "Olavarria")));
//        };
//    }
}
