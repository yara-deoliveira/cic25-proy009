package es.cic.curso25.proy009.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.proy009.model.Rama;
import es.cic.curso25.proy009.repository.RamaRepository;

@Service
@Transactional
public class RamaService {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RamaService.class);


    @Autowired
    private RamaRepository ramaRepository;

    //Operaciones CRUD: Create, Read, Update, Delete

    //Create
    public Rama create(Rama rama){

        LOGGER.info("Creando una rama");
        rama = ramaRepository.save(rama);
        return rama;
    }

    //Read - One
    @Transactional(readOnly = true)
    public Optional<Rama> get(long id){

        Optional<Rama> resultado = ramaRepository.findById(id);

        return resultado;
    }

    //Read - All
    @Transactional(readOnly = true)
    public List<Rama> getAll(){

        return ramaRepository.findAll();
    }

    //Update
    public void update (Rama rama){

        LOGGER.info("Actualizando una rama");
        ramaRepository.save(rama);
    }

    //Delete
    public void delete (long id){
        
        LOGGER.info("Borrando una rama");
        ramaRepository.deleteById(id);
    }

    
}
