package com.zk.myspittr.web;

import com.zk.myspittr.Spitter;
import com.zk.myspittr.data.SpitterRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

public class SpitterControllerTest {

    @Test
    public void showRegistrationForm() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();

        mvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);

        Spitter unsaved = new Spitter("zk", "123", "zhao", "ke", "zk@123.com");
        Spitter saved = new Spitter(24L, "zk", "123", "zhao", "ke", "zk@123.com");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();

        mvc.perform(MockMvcRequestBuilders.post("/spitter/register")
//                .param("firstName", "")
                .param("lastName", "ke")
                .param("username", "zk")
                .param("password", "123")
                .param("email", "zk@123.com"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/zk"));

        verify(mockRepository, atLeastOnce()).save(unsaved);

    }
}