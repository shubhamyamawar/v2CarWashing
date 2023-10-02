//package com.admin.controller;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.admin.models.WashPacks;
//import com.admin.service.AdminServiceImpl;
//
//public class AdminControllerTest {
//
//    private AdminController adminController;
//    private AdminServiceImpl adminService;
//
//    @BeforeEach
//    public void setUp() {
//        // Create a mock instance of the AdminServiceImpl
//        adminService = mock(AdminServiceImpl.class);
//
//        // Create an instance of your controller, passing in the mock adminService
//        adminController = new AdminController();
//    }
//
//    @Test
//    public void testBookWash() {
//        // Create a sample WashPacks object
//        WashPacks samplePacks = new WashPacks(/* initialize your sample data */);
//
//        // Mock the behavior of adminService.addNewWashPack to return a specific WashPacks object
//        when(adminService.addNewWashPack(any(WashPacks.class))).thenReturn(samplePacks);
//
//        // Call the method you want to test
//        ResponseEntity<Object> responseEntity = adminController.bookWash(samplePacks);
//
//        // Verify that adminService.addNewWashPack was called with the correct argument
//        verify(adminService).addNewWashPack(samplePacks);
//
//        // Verify that the ResponseEntity has the expected status code
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//
//        // Verify that the ResponseEntity body matches the expected WashPacks object
//        assertEquals(samplePacks, responseEntity.getBody());
//    }
//}
