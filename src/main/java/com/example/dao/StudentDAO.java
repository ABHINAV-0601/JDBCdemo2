package com.example.dao;

import com.example.data.Student;
import com.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {
    public int insertIntoStudent(Student student) throws SQLException, ClassNotFoundException {
        int row = 0;
        Connection connection = DbConnection.getConnection();

        String sql = "insert into student_tbl (name, rollNo, email,address,class) values (?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,student.getName());
        preparedStatement.setInt(2,student.getRollNo());
        preparedStatement.setString(3,student.getEmail());
        preparedStatement.setObject(4,student.getAddress());
        preparedStatement.setObject(5,student.getStandard());

        row = preparedStatement.executeUpdate();
        return row;
    }
}
