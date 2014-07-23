package com.agrownet.solutions.emarket.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

public class SiteIntegrationTest {
	private static final String RESPONSE_BODY="Hello AgrowNet, Wish you a great success!";
	
	MockMvc mockMvc;
	
	@InjectMocks
    SiteController controller;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
        //when(menuService.requestAllMenuItems(any(RequestAllMenuItemsEvent.class))).thenReturn(WebDataFixture.allMenuItems());
    }

    @Test
    public void thatTextReturned() throws Exception {
        mockMvc.perform(get("/initjourney")).andDo(print()).andExpect(content().string(RESPONSE_BODY));
    }
}
