package com.example.bvnvalidation;

import com.example.bvnvalidation.controller.BvnController;
import com.example.bvnvalidation.dto.ValidationDto;
import com.example.bvnvalidation.exception.ApiException;
import com.example.bvnvalidation.exception.ApiRequestException;
import com.example.bvnvalidation.model.BvnValidation;
import com.example.bvnvalidation.service.abstracts.BvnValidationService;
import com.example.bvnvalidation.service.concretes.BvnValidationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class BvnControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    BvnValidationService bvnValidationService;
//
//
//    ValidationDto testOne = new ValidationDto("22526136104");
//    ValidationDto testTwo = new ValidationDto("");
//    ValidationDto testThree = new ValidationDto("22526136894");
//    ValidationDto testFour = new ValidationDto("400500");
//    ValidationDto testFive = new ValidationDto("2252v136y0d");
//
//    @Test
//    public  void validateTestOne () throws Exception {
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/bv-service/svalidate/wrapper")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(testOne));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(jsonPath("$.imageDetail",notNullValue()))
//                .andExpect(jsonPath("$.imageDetail", Matchers.not("")))
//                .andExpect(jsonPath("$.basicDetail",notNullValue()))
//                .andExpect(jsonPath("$.basicDetail", Matchers.not("")))
//                .andExpect(jsonPath("$.message",is("Success")))
//                .andExpect(jsonPath("$.code", is(00)))
//                .andExpect(jsonPath("$.bvn", is(testOne.getBvn())));
//
//    }
//    imageDetail: 'imageDetails1',
//    basicDetail: 'basicDetailsOne',
//    message: 'Success',
//    code: '00',
//    bvn: '22526136104'
//
//    Message -> Success
//    Code -> 00
//    Bvn -> same in request payload
//    ImageDetail -> not null and not blank
//    BasicDetail -> not null and not blank

    @InjectMocks // This allows to inject Mock objects.
    BvnController bvnController;

    @Mock
    BvnValidationServiceImpl bvnValidationService;

    BvnValidation bvnValidation;

    @BeforeEach
    void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
//        ValidationDto testOne = new ValidationDto("22526136104");
////    ValidationDto testTwo = new ValidationDto("");
////    ValidationDto testThree = new ValidationDto("22526136894");
////    ValidationDto testFour = new ValidationDto("400500");
////    ValidationDto testFive = new ValidationDto("2252v136y0d");

       bvnValidation = new BvnValidation("imageDetails1","basicDetailsOne","Success","00","22526136104");



    }
    @Test
    void testSuccessfulValidation()
    {
               ValidationDto testOne = new ValidationDto("22526136104");
        // Fake the getUserByUserId method call using mocked userService object
        when(bvnValidationService.bvnValidation(testOne)).thenReturn(bvnValidation);
       BvnValidation validation = bvnController.validate(testOne);
        assertNotNull(validation.getBasicDetail());
        assertNotEquals(validation.getBasicDetail(),"");
        assertNotNull(validation.getImageDetail());
        assertNotEquals(validation.getImageDetail(),"");
        assertEquals(validation.getMessage(), "Success");
        assertEquals(validation.getCode(),"00");
        assertEquals(validation.getBvn(),testOne.getBvn());

    }
//Unable to complete Exception Tests due to previous weekends commitments
//    @Test
//    void testOneValidation(){
//        ValidationDto testTwo = new ValidationDto("");
//        ApiException apiException = new ApiException("One or more of your request parameters failed validation. Please retry","400");
//        when(bvnValidationService.bvnValidation(testTwo)).thenReturn(bvnValidation);
//        BvnValidation validation = bvnController.validate(testTwo);
////        ApiRequestException thrown = assertThrows(
////                ApiRequestException.class,
////                () -> bvnController.validate(testTwo),"One or more of your request parameters failed validation. Please retry,400"
////        );
//        assertThrows(ApiRequestException.class, () ->{ bvnController.validate(testTwo);});
//
//
////        assertTrue(thrown.getMessage().equals(apiException));
//    }


}
