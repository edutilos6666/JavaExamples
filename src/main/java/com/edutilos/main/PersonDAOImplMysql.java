package com.edutilos.main;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImplMysql implements  PersonDAO{

    private final String host = "localhost";
    private final int port = 3306 ;
    private final String dbname = "php_test";
    private Connection conn ;
    private Statement stmt;
    private ResultSet rs ;
    private PreparedStatement pstmt;
    private final String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", host , port, dbname);
    private final String user = "root";
    private final String password = "root";
    private String sql = "";
    private final String tablename = "Person";
    public void connect() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url, user , password);
            stmt = conn.createStatement();
            System.out.println("Connection successfull!");
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void disconnect() {
       try {
           if(pstmt != null) pstmt.close();
           if(rs != null) rs.close();
           if(stmt != null) stmt.close();
           if(conn != null) conn.close();
       } catch(Exception ex) {
           System.err.println(ex.getMessage());
       }
    }


    public void dropTable() {
      try {
          sql =  String.format("drop table if exists %s", tablename);
          stmt.execute(sql);
      } catch(Exception ex) {
          System.err.println(ex.getMessage());
      }
    }

    public void createTable() {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("create table if not exists %s")
                    .append("(")
                    .append("id bigint primary key auto_increment, ")
                    .append("name varchar(50) not null , ")
                    .append("age int not null, ")
                    .append("wage real not null, ")
                    .append("active boolean not null")
                    .append(")");
            sql = String.format(builder.toString(), tablename);
            stmt.execute(sql);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void save(Person p) {
     try {
         sql = "insert into %s (name , age , wage, active) values(?, ?, ?, ?)";
         sql = String.format(sql , tablename);
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1 , p.getName());
         pstmt.setInt(2, p.getAge());
         pstmt.setDouble(3, p.getWage());
         pstmt.setBoolean(4, p.isActive());
         pstmt.execute();
         pstmt.close();
     } catch(Exception ex) {
         System.err.println(ex.getMessage());
     }
    }

    @Override
    public void update(long id, Person newP) {
       try {
           sql = "update %s set name = ?, age = ?, wage = ?, active = ? where id = ?";
           sql = String.format(sql , tablename);
           pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, newP.getName());
           pstmt.setInt(2, newP.getAge());
           pstmt.setDouble(3, newP.getWage());
           pstmt.setBoolean(4 , newP.isActive());
           pstmt.setLong(5 , newP.getId());
           pstmt.execute();
           pstmt.close();
       } catch(Exception ex) {
           System.err.println(ex.getMessage());
       }
    }

    @Override
    public void remove(long id) {
        try {
            sql = "delete from %s where id = ?";
            sql = String.format(sql , tablename);
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public Person findById(long id) {
        Person ret = null;
        try {
            sql = "select * from %s where id = ?";
            sql = String.format(sql, tablename);
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ret = mapRSToPerson();
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ret ;
    }

    @Override
    public List<Person> findAll() {
        List<Person> ret = new ArrayList<>();
        try {
            sql = "select * from %s";
            sql = String.format(sql , tablename);
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                ret.add(mapRSToPerson());
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ret;
    }

    private Person mapRSToPerson() throws Exception {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        double wage = rs.getDouble("wage");
        boolean active = rs.getBoolean("active");
        return new Person(id, name, age, wage, active);
    }
}
