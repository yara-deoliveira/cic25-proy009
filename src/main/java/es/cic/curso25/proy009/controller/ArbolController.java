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

import es.cic.curso25.proy009.model.Arbol;
import es.cic.curso25.proy009.service.ArbolService;

@RestController
@RequestMapping("/api/capitan")
public class ArbolController {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ArbolController.class);


    @Autowired
    private ArbolService arbolService;

    //Operaciones CRUD: Create, Read, Update, Delete

    //Read - All
    @GetMapping
    public List<Arbol> get(){

        return arbolService.getAll();
    }

    //Read - One
    @GetMapping("/{id}")
    public Optional<Arbol> get(@PathVariable long id){
        LOGGER.info("Consultando el árbol con id " + id);
        Optional <Arbol> arbol = arbolService.get(id);

        return arbol;
    }

    //Create
    @PostMapping
    public Arbol create(@RequestBody Arbol arbol){
        LOGGER.info("Creando un árbol nuevo " + arbol);
        Arbol arbolNuevo = arbolService.create(arbol);

        return arbolNuevo;
    }

    //Update
    @PutMapping
    public void update(@RequestBody Arbol arbol){
        arbolService.update(arbol);
    }

    //Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        arbolService.delete(id);
    }

}
