package com.example.springboot;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
	private int port;

    @Autowired
	private MockMvc mockMvc;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
        System.out.println("User Controller TEST.......................");
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hi Sanket, Greetings from Spring Boot!")));
    }
    
    @Test
	public void addUser() throws Exception {
        System.out.println("**************** Add Users ****************");

        this.mockMvc.perform(post("/users")
            .param("fName", "Sanket")
            .param("lName", "Parekh")
            .param("email", "Test@email.com")
            .param("phone", "1234567890"))
        .andDo(print()).andExpect(status().isOk());
        
        System.out.println("**************** Get Users Response Started ****************");
        System.out.println(this.mockMvc.perform(get("/users")).andDo(print()));
        System.out.println("**************** Get Users Response End ****************");
				
    }
    
    @Test
	public void updateUser() throws Exception {
        System.out.println("**************** UPDATE Users ****************");

        this.mockMvc.perform(patch("/users/1")
            .param("fName", "Sanket1")
            .param("lName", "Parekh1")
            .param("email", "Test@email1.com")
            .param("phone", "1234567891"))
        .andDo(print()).andExpect(status().isOk());
        
        System.out.println("**************** Get Users Response Started ****************");
        System.out.println(this.mockMvc.perform(patch("/users")).andDo(print()));
        System.out.println("**************** Get Users Response End ****************");
				
    }
    
    @Test
	public void deleteUser() throws Exception {
        System.out.println("**************** DELETE Users ****************");

        this.mockMvc.perform(delete("/users/1"))
            .andDo(print()).andExpect(status().isOk());
        
        System.out.println("**************** Get Users Response Started ****************");
        System.out.println(this.mockMvc.perform(get("/users")).andDo(print()));
        System.out.println("**************** Get Users Response End ****************");
	}

    @Test
	public void getUsers() throws Exception {
        System.out.println("**************** Get Users ****************");
        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
        
        System.out.println("**************** Get Users Response Started ****************");
        System.out.println(this.mockMvc.perform(get("/users")).andDo(print()));
        System.out.println("**************** Get Users Response End ****************");
				
	}
}