package es.cic.curso25.proy009.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proy009.model.Arbol;
import es.cic.curso25.proy009.repository.ArbolRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class ArbolControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ArbolRepository arbolRepository;

    //Test Create - POST
    @Test
    void testCreate() throws Exception{
        Arbol arbol = new Arbol();
        arbol.setNombreComun("Cerezo");
        arbol.setTipoTronco("Rugoso");
        arbol.setAltura(10.2);
        arbol.setAnchura(1.4);

        String arbolJson = objectMapper.writeValueAsString(arbol);

        mockMvc.perform(post("/api/arbol")
            .contentType("application/json")
            .content(arbolJson))
            .andExpect(status().isOk())
            .andExpect(result -> {
                String respuesta = result.getResponse().getContentAsString();
                                Arbol registroCreado = objectMapper.readValue(respuesta, Arbol.class);
                                assertTrue(registroCreado.getId() > 0, "El valor debe ser mayor que 0");

                                Optional<Arbol> registroRealmenteCreado = arbolRepository.findById(registroCreado.getId());
                                assertTrue(registroRealmenteCreado.isPresent());
            });

    }
    
    //Test GET 
    @Test
    void testGet() throws Exception {
        Arbol arbol = new Arbol();
        arbol.setNombreComun("Tejo");
        arbol.setTipoTronco("Rugoso");
        arbol.setAltura(4.1);
        arbol.setAnchura(0.7);

        String arbolJson = objectMapper.writeValueAsString(arbol);

        mockMvc.perform(post("/api/arbol")
            .contentType("application/json")
            .content(arbolJson))
            .andExpect(status().isOk());

        mockMvc.perform(get("/api/arbol/1"))
                .andExpect(status().isOk());
    
        }


    //Test DELETE
    @Test
    void testDelete() throws Exception {
        Arbol arbol = new Arbol();
        arbol.setNombreComun("Manzano");
        arbol.setTipoTronco("Liso");
        arbol.setAltura(6.7);
        arbol.setAnchura(1.5);

        String arbolJson = objectMapper.writeValueAsString(arbol);

        mockMvc.perform(post("/api/arbol")
                .contentType("application/json")
                .content(arbolJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/arbol/1"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/arbol/1"))
                .andExpect(status().isOk())
                .andReturn();
         }
}

