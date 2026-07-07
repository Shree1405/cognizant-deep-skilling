package com.library.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.library.config.AppConfig;
import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BookService service =
                context.getBean(BookService.class);

        service.displayService();

        ((AnnotationConfigApplicationContext) context).close();

    }

}