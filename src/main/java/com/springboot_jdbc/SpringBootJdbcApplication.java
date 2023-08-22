package com.springboot_jdbc;

import com.springboot_jdbc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcApplication.class, args);
    }

    //method for running non-static methods
    @Override
    public void run(String... args) throws Exception {

//        userRepository.createUserTable();

//        this.createUser();

//        this.updateUser();

        this.deleteUser();
    }

    //method for inserting user into database dynamically
    public void createUser() throws IOException {

        //taking input from commandline
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter user_id : ");
        int id = Integer.parseInt(br.readLine());

        System.out.print("Enter name : ");
        String name = br.readLine();

        System.out.print("Enter age : ");
        int age = Integer.parseInt(br.readLine());

        System.out.print("Enter city : ");
        String city = br.readLine();

        //insert data
        this.userRepository.insertUser(id, name, age, city);
    }

    //method for updating user
    public void updateUser() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter id : ");
        int id = Integer.parseInt(br.readLine());

        System.out.print("Enter name : ");
        String name = br.readLine();

        System.out.print("Enter age : ");
        int age = Integer.parseInt(br.readLine());

        System.out.print("Enter city : ");
        String city = br.readLine();

        this.userRepository.updateUser(id, name, age, city);
    }

    //method for delete user from database
    public void deleteUser() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter id : ");
        Integer id = Integer.parseInt(br.readLine());

        this.userRepository.deleteUser(id);
    }
}
