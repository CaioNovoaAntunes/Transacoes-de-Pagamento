package br.com.orange.carteira.cartoes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class NovoCartaoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private EntityManager manager;


    @Test
    public void deveRetornar201() throws Exception{
        NovoCartaoRequest novoCartaoRequest;
    }

}