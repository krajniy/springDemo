package de.telran.springdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.telran.springdemo.controller.GreetingController;
import de.telran.springdemo.entity.Greeting;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Autowired
    ObjectMapper mapper;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GreetingService service;

    @Nested
    @DisplayName("GET greeting tests")
    class GetGreetingTests {

        @Test
        @DisplayName("Greeting found and returned")
        void Should_ReturnGreetingAndStatus200() throws Exception { // /greet/1
//            Mockito.when(service.get(any(Long.class)))
//                    .thenAnswer(i -> new Greeting(i.getArgument(0, Long.class), "Test", 3));
            Mockito.when(service.get(any(Long.class)))
                    .thenAnswer(i -> new Greeting());

            mockMvc.perform(get(API_PATH + "1"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$").isNotEmpty())
                    .andExpect(jsonPath("$.id").value(1))
                    .andExpect(jsonPath("$.count").value(3))
                    .andExpect(jsonPath("$.value").value("Test"))
                    .andDo(print());

            Mockito.verify(service, times(1)).get(any(Long.class));
        }

        @Test
        @DisplayName("Greeting not found and 404 returned")
        void Should_ReturnStatus404() throws Exception {
            Mockito.when(service.get(any(Long.class)))
                    .thenAnswer(i -> { throw new IllegalArgumentException(); });

            mockMvc.perform(get(API_PATH + "1"))
                    .andExpect(status().isNotFound())
                    .andDo(print());
        }
    }

    @Nested
    @DisplayName("POST greeting tests")
    class GreetingCreationTest {

        @Test
        @DisplayName("Greeting successfully posted")
        void Should_ReturnIdAndStatus200() throws Exception {
            Mockito.when(service.create(any(Greeting.class)))
                    .thenAnswer(i -> 1);

            mockMvc.perform(post(API_PATH)
                            .content(mapper.writeValueAsString(new Greeting()))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$").isNotEmpty())
                    .andExpect(jsonPath("$.id").value(1))
                    .andDo(print());
        }
    }
}

