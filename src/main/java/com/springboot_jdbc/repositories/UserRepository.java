package com.springboot_jdbc.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for create table
    public int createUserTable() {

        //create table query
        String query = "create table B_User(id number(10) primary key, name varchar2(100) not null, age number(3), city varchar2(100))";

        //fire query
        int result = this.jdbcTemplate.update(query);

        System.out.println("Table Created...!");

        return result;
    }

    //method for insert data into table
    public void insertUser(int id, String name, int age, String city) {

        //insert query
        String query = "insert into b_user(id, name, age, city) values(?, ?, ?, ?)";

        //fire query
        this.jdbcTemplate.update(query, new Object[]{id, name, age, city});

        System.out.println("User Inserted..!");
    }

    //method for update data of table
    public void updateUser(int id, String name, int age, String city) {

        String query = "update b_user set name=?,age=?, city=? where id=?";

        this.jdbcTemplate.update(query, new Object[]{name, age, city, id});

        System.out.println("User Updated..!");
    }

    //method for delete user from database
    public void deleteUser(int id) {

        String query = "delete from b_user where id=?";

        this.jdbcTemplate.update(query, id);

        System.out.println("User removed from database..!");
    }
}
