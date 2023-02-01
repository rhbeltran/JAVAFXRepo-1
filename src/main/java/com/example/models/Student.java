package com.example.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.dbhander.PostgresConnect;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student extends Person {
    private int level;

    /**
     * Constructor
     * @param id
     * @param firstName
     * @param lastName
     * @param birthday
     * @param email
     * @param phoneNumber
     * @param level
     */
    public Student(String id, String firstName, String lastName, LocalDate birthday, String email, String phoneNumber,
            int level) {
        super(id, firstName, lastName, birthday, email, phoneNumber);
        this.level = level;
    }

    /**
     * Gets level
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }    
    
    /**
     * Prints the student
     */
    @Override
    public void print() {
        // TODO Auto-generated method stub
        super.print();
        System.out.println("Level: " + this.level);
    }

    @Override
    public String getFullName() {
        // TODO Auto-generated method stub
        return super.getFullName();
    }

    /**
     * Gets simple string property from id
     * @return SimpleStringProperty
     */
    public SimpleStringProperty idProperty() {
        return new SimpleStringProperty(this.getId());
    }

    /**
     * Gets simple string property from name
     * @return
     */
    public SimpleStringProperty firstNameProperty() {
        return new SimpleStringProperty(this.getFirstName());
    }

    /**
     * Gets simple string property from email
     * @return
     */
    public SimpleStringProperty emailProperty() {
        return new SimpleStringProperty(this.getEmail());
    }

    /**
     * Gets simple string property from lastName
     * @return
     */
    public SimpleStringProperty lastNameProperty() {
        return new SimpleStringProperty(this.getLastName());
    }

    /**
     * Gets simple string property from age student.save();
     * @return
     */
    public SimpleIntegerProperty ageProperty() {
        return new SimpleIntegerProperty(this.getAge());
    }

    public void save(){
        final String sql = "INSERT INFO student " + 
        "(id, first_name, last_name, email) VALUES"+"(?,?,?,?)";
        PostgresConnect pgConnect=new PostgresConnect();
        Connection connection = pgConnect.getConnection();
        try(PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setString(1, this.getId());
            preparedStatement.setString(1, this.getFirstName());
            preparedStatement.setString(1, this.getLastName());
            preparedStatement.setString(1, this.getEmail());
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        } 
    }
}