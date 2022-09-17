package com.example.Spring.controller;

import com.example.Spring.model.Role;
import com.example.Spring.model.User;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DynamicRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    Role role = Role.builder()
            .role("ROLE_ADMIN").build();

    User user = User.builder()
            .firstname("farzad")
            .lastname("afshar")
            .username("farzadAfi")
            .password("afi")
            .role(role).build();


    @BeforeAll
    static void setup(@Autowired DataSource dataSource) {
        try (Connection connection = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(connection, new ClassPathResource("dynamicRoleTestData.sql"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dynamicRoleTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dynamicRole/test")
                .with(SecurityMockMvcRequestPostProcessors.user(user))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}