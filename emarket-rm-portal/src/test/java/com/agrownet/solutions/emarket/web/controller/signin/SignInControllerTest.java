package com.agrownet.solutions.emarket.web.controller.signin;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import com.agrownet.solutions.emarket.web.config.WebAppConfigurationAware;

public class SignInControllerTest extends WebAppConfigurationAware {
    @Test
    public void displaysLoginPage() throws Exception {
        mockMvc.perform(get("/signin"))
                .andExpect(view().name("signin/signin"))
                .andExpect(content().string(
                        allOf(
                                containsString("<title>Sign In</title>"),
                                containsString("<legend>Please Sign In</legend>")
                        ))
                );
    }
}