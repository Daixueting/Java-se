package com.bittec;

import java.net.ConnectException;
import java.sql.*;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: jdbcCase3
 * @USER: 代学婷
 * @AIM:   采用模板设计模式
 * @DATE: 2019/11/5
 **/

/*
 * 不变的：加载驱动，获取连接，创建命令，关闭
 * 改变的：SQL,执行结果，处理结果（select，insert,update,delete)
 *
 * */
public abstract class AbstractJdbcTemplate {
    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;

    //加载驱动
    private void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    private void createConnection(){
        try {
            String url="jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99";
            connection= DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //创建命令
    private void createStatement(){
        try {
           this.statement=this.connection.createStatement();;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //处理命令
    private int executeUpdate(String sql){
        try {
            return this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    private ResultSet createQuery(String sql){
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public abstract<T> T handlerResult(ResultSet resultSet);
    public abstract<T> T handlerResult(int effect);
    //关闭
    private void close(){
        if (this.resultSet!=null){
            //7.关闭结果
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.statement!=null){
            //8.关闭命令
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.connection!=null){
            //9.关闭连接
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public <T> T execute(String sql){
        Object t;
        this.loadDriver();
        this.createConnection();
        this.createStatement();
        //执行SQL
        //假设CRUD
        if(sql.trim().toUpperCase().startsWith("SELECT")){
            this.resultSet=this.createQuery(sql);
            t=this.handlerResult(resultSet);
        }else {
            int effect=this.executeUpdate(sql);
            t=this.handlerResult(effect);
        }
        this.close();
        return (T) t;
    }

}
