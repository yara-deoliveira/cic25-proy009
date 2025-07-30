package es.cic.curso25.proy009.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso25.proy009.model.Arbol;
import es.cic.curso25.proy009.repository.ArbolRepository;

@Service
@Transactional
public class ArbolService {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ArbolService.class);

    @Autowired
    private ArbolRepository arbolRepository;

    //Operaciones CRUD: Create, Read, Update, Delete

    //Create
    
    public Arbol create(Arbol arbol){
      arbol = arbolRepository.save(arbol);
        LOGGER.info("Creando un árbol");
        return arbol;  
    }

    //Read - One
    @Transactional(readOnly = true)
    public Optional <Arbol> get(long id){
        Optional<Arbol> resultado = arbolRepository.findById(id);

        return resultado;
    }

    //Read - All
    @Transactional(readOnly = true)
    public List<Arbol> getAll(){
        return arbolRepository.findAll();
    }

    //Update
    public void update (Arbol arbol){
        LOGGER.info("Actualizando un árbol");
        arbolRepository.save(arbol);
    }

    //Delete
    public void delete (long id){
        LOGGER.info("Borrando un árbol");
        arbolRepository.deleteById(id);
    }



}

