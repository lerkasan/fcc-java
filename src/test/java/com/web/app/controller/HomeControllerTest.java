package com.web.app.controller;

import com.web.app.config.BaseConfigTest;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest extends BaseConfigTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private MockHttpSession session;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
    }

    //Test: public String index_GET()
    @SneakyThrows
    @Test
    public void test_index_GET() throws Exception {
        this.mockMvc.perform(get("/").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    //Test: public String home_GET()
    @SneakyThrows
    @Test
    public void test_home_GET() throws Exception {
        this.mockMvc.perform(get("/home").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("views/home"));
    }

    //Test: public String info_GET()
    @SneakyThrows
    @Test
    public void test_info_GET() throws Exception {
        this.mockMvc.perform(get("/info").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("views/info"));
    }

    //Test: public String contacts_GET()
    @SneakyThrows
    @Test
    public void test_contacts_GET() throws Exception {
        this.mockMvc.perform(get("/contacts").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("views/contacts"));
    }

}
