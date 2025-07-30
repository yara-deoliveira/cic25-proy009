package es.cic.curso25.proy009.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.proy009.model.Rama;
import es.cic.curso25.proy009.repository.RamaRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class RamaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RamaRepository ramaRepository;

    //Test Create - POST
    @Test
    void testCreate() throws Exception{
        Rama rama = new Rama();
        rama.setColorHoja("Verde");
        rama.setFormaHoja("Ovalada");
        rama.setFrutal(false);

        String ramaJson = objectMapper.writeValueAsString(rama);

        mockMvc.perform(post("/api/rama")
            .contentType("application/json")
            .content(ramaJson))
            .andExpect(status().isOk())
            .andExpect(result -> {
                String respuesta = result.getResponse().getContentAsString();
                                Rama registroCreado = objectMapper.readValue(respuesta, Rama.class);
                                assertTrue(registroCreado.getId() > 0, "El valor debe ser mayor que 0");

                                Optional<Rama> registroRealmenteCreado = ramaRepository.findById(registroCreado.getId());
                                assertTrue(registroRealmenteCreado.isPresent());
            });

    }
    
    //Test GET 
    @Test
    void testGet() throws Exception {
        Rama rama = new Rama();
        rama.setColorHoja("Naranja");
        rama.setFormaHoja("Palmada");
        rama.setFrutal(false);

        String ramaJson = objectMapper.writeValueAsString(rama);

        mockMvc.perform(post("/api/rama")
            .contentType("application/json")
            .content(ramaJson))
            .andExpect(status().isOk());

        mockMvc.perform(get("/api/rama/1"))
                .andExpect(status().isOk());
    
        }


    //Test DELETE
    @Test
    void testDelete() throws Exception {
        Rama rama = new Rama();
        rama.setColorHoja("Verde");
        rama.setFormaHoja("Ovalada");
        rama.setFrutal(true);


        String ramaJson = objectMapper.writeValueAsString(rama);

        mockMvc.perform(post("/api/rama")
                .contentType("application/json")
                .content(ramaJson))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/rama/1"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/api/rama/1"))
                .andExpect(status().isOk())
                .andReturn();
         }
}

