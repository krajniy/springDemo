package de.telran.springdemo.controller;
import de.telran.springdemo.model.Greeting;
import de.telran.springdemo.service.GreetingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.StandardCharsets;

/*@SpringBootTest()*/
@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = GreetingController.class)
@AutoConfigureMockMvc
@DisplayName("Tests for GreetingController API")
class GreetingControllerTest {
    static final String API_PATH = "/greet/";
    static final MediaType APP_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8);

    @Autowired MockMvc mockMvc;

    @MockBean GreetingService service;

    @Nested
    @DisplayName("GET greeting tests")
    class GetGreetingTests {

        @Test
        @DisplayName("Greeting found and returned")
        void Should_ReturnGreetingAndStatus200() throws Exception { // /greet/1
            Mockito.when(service.get(any(Long.class)))
                    .thenAnswer(i -> new Greeting(i.getArgument(0, Long.class), "Test", 3));

            mockMvc.perform(get(API_PATH + "1"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$").isNotEmpty())
                    .andExpect(jsonPath("$.id").value(1))
                    .andExpect(jsonPath("$.count").value(3))
                    .andExpect(jsonPath("$.value").value("Test"))
                    .andDo(print());
        }

        @Test
        @DisplayName("Greeting not found and 404 returned")
        void Should_ReturnStatus404() {

        }
    }

    @Nested
    @DisplayName("POST greeting tests")
    class GreetingCreationTest {

    }
}