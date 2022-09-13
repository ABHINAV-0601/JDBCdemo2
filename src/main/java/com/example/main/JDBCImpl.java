package com.example.main;
import com.example.dao.AddressDAO;
import com.example.dao.StandardDAO;
import com.example.dao.StudentDAO;
import com.example.data.Address;
import com.example.data.Standard;
import com.example.data.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class JDBCImpl {
    public static void main(String[] args) {
        //name, rollNo, email, address and class name or class id
        // we want to insert them in database
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter full name");
        String name = scanner.nextLine();
        System.out.println("enter roll number");
        int rollNo = scanner.nextInt();
        System.out.println("enter email");
        scanner.nextLine();
        String email = scanner.nextLine();
        System.out.println("enter class to     enroll");
        String standard = scanner.nextLine();
        System.out.println("enter section");
        String section = scanner.nextLine();
        System.out.println("Address Details");
        System.out.println("enter flat no");
        int flatNo = scanner.nextInt();
        System.out.println("enter building name");
        scanner.nextLine();
        String buildingName = scanner.nextLine();
        System.out.println("enter street");
        String street = scanner.nextLine();
        System.out.println("enter city");
        String city = scanner.nextLine();
        System.out.println("enter state");
        String state = scanner.nextLine();
        System.out.println("enter pin code");
        int pinCode = scanner.nextInt();
        System.out.println("enter country");
        scanner.nextLine();
        String country = scanner.nextLine();

        //I want to insert them in database named studentMgmt
        // student details will enter student table
        // address details will enter address table
        // class details will enter class table
        Address a1 = new Address(flatNo, buildingName, street, city, state, pinCode, country);
        Standard s1 = new Standard(standard, section);
        Student student = new Student(name, rollNo,email,a1,s1);

        //call insert method to insert the value into student table

        StandardDAO standardDAO = new StandardDAO();
        AddressDAO addressDAO = new AddressDAO();
        StudentDAO studentDAO = new StudentDAO();
        int rows = 0;
        int classrows = 0;
        int studentrows = 0;
        //int generatedKey = 0;
        try {
            //generatedKey = standardDAO.insertIntoStandard(s1);
            rows = addressDAO.insertIntoAddress(a1);
            classrows = standardDAO.insertIntoStandard(s1);
            studentrows = studentDAO.insertIntoStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println("generatedKey =" + generatedKey);
        System.out.println("rows affected = " + rows);
        System.out.println("Class rows affected = " + classrows);
        System.out.println("Student rows affected = " + studentrows);
    }
}
