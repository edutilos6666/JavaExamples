package com.edutilos.database.mysql;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 18.06.17.
 */
public class Example1 {
    public static void main(String[] args) {
        test1();
    }


    private static void test1() {
        //properties
        Connection conn = null ;
        Statement stmt = null ;
        ResultSet rs = null ;
        PreparedStatement pstmt = null;

        final String username = "root";
        final String password = "root";
        final String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";

        try {
            //connect
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            System.out.println("Connection success");


            //create table
            StringBuilder sb = new StringBuilder();
            sb.append("drop table if exists MysqlPerson");
            stmt.execute(sb.toString());

            sb = new StringBuilder();
            sb.append("create table if not exists MysqlPerson (")
                    .append("id bigint primary key auto_increment, ")
                    .append("name varchar(50) not null, ")
                    .append("age int not null, ")
                    .append("wage double not null)");
            stmt.execute(sb.toString());

            //insert into table
            List<MysqlPerson> list = Arrays.asList(
                    new MysqlPerson("foo", 10, 100.0),
                    new MysqlPerson("bar", 20, 200.0),
                    new MysqlPerson("bim", 30 , 300.0)
            );

            sb = new StringBuilder();
            sb.append("insert into MysqlPerson (name, age, wage) VALUES(?,?,?)");
            pstmt = conn.prepareStatement(sb.toString());
            for(MysqlPerson p: list) {
                pstmt.setString(1, p.getName());
                pstmt.setInt(2, p.getAge());
                pstmt.setDouble(3, p.getWage());
                pstmt.execute();
            }

            //select * from table
            sb = new StringBuilder();
            sb.append("select * from MysqlPerson");
            rs = stmt.executeQuery(sb.toString());
            while(rs.next()) {
                System.out.println(mapRSToPerson(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(pstmt != null)
                pstmt.close();
                if(stmt != null)
                stmt.close();
                if(rs != null)
                rs.close();
                if(conn != null)
                conn.close();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

    }


    private static MysqlPerson mapRSToPerson(ResultSet rs) throws Exception {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        double wage = rs.getDouble("wage");
        return new MysqlPerson(id, name, age, wage);
    }

    private static class MysqlPerson {
        private long id ;
        private String name;
        private int age;
        private double wage;

        public MysqlPerson(long id, String name, int age, double wage) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.wage = wage;
        }

        public MysqlPerson() {
        }

        public MysqlPerson(String name, int age, double wage) {
            this.name = name;
            this.age = age;
            this.wage = wage;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getWage() {
            return wage;
        }

        public void setWage(double wage) {
            this.wage = wage;
        }

        @Override
        public String toString() {
            return String.format("%d,%s,%d,%.2f", id , name, age, wage);
        }
    }
}
