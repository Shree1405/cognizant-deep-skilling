package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.service.AttemptService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        testGetAttemptDetail();
    }

    private void testGetAttemptDetail() {

        Attempt attempt = attemptService.getAttempt(1, 1);

        if (attempt == null) {
            System.out.println("Attempt not found");
            return;
        }

        System.out.println("Attempt ID : " + attempt.getId());
        System.out.println("Attempt Date : " + attempt.getAttemptDate());
        System.out.println("User ID : " + attempt.getUser().getId());
        System.out.println("User Name : " + attempt.getUser().getUsername());

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {

            System.out.println("--------------------------------");
            System.out.println("Question ID : " + aq.getQuestion().getId());
            System.out.println("Question : " + aq.getQuestion().getText());

            for (AttemptOption ao : aq.getAttemptOptions()) {

                System.out.println("Option ID : " + ao.getOption().getId());
                System.out.println("Option : " + ao.getOption().getText());
                System.out.println("Score : " + ao.getOption().getScore());
                System.out.println("Selected : " + ao.isSelected());
                System.out.println();
            }
        }
    }
}