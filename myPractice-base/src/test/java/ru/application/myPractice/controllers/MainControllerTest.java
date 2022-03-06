package ru.application.myPractice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MainControllerTest {

    @Autowired
    private MainController controller;

    @Test
    public void contextLoads() {
        //given
        //when
        //then
        assertThat(controller).isNotNull();
    }
}