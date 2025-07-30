package es.cic.curso25.proy009.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso25.proy009.model.Rama;
import es.cic.curso25.proy009.service.RamaService;

@RestController
@RequestMapping("/api/rama")
public class RamaController {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(RamaController.class);

    @Autowired
    private RamaService ramaService;

    //Operaciones CRUD: Create, read, update, delete

    //Read - All
    @GetMapping
    public List<Rama> get(){
        
        return ramaService.getAll(); 
    }

    //Read - One
    @GetMapping("/{id}")
    public Optional<Rama> get(@PathVariable long id){
        LOGGER.info("Consultando la rama con id " + id);
        Optional<Rama> rama = ramaService.get(id);

        return rama;
    }

    //Create
    @PostMapping
    public Rama create(@RequestBody Rama rama){
        LOGGER.info("Creando una rama nueva " + rama);
        Rama ramaNueva = ramaService.create(rama);

        return ramaNueva;
    }

    //Update
    @PutMapping
    public void update(@RequestBody Rama rama){
        ramaService.update(rama);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        ramaService.delete(id);
    }
    

}
