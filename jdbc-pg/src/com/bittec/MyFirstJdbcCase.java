package com.bittec;

import java.sql.*;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: MyFirstJdbcCase
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/4
 **/
public class MyFirstJdbcCase {
    public static void main(String[] args) {
        /* //首先要启动数据库,而且数据库中的下标都是从1开始的

        * 1.加载数据库的JDBC驱动
        * 2.创建连接
        * 3.创建命令
        * 4.准备sql语句
        * 5.执行sql
        * 6.处理结果
        * 7.关闭结果
        * 8.关闭命令
        * 9.关闭连接
        * */
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //JDBC URL协议
            //jdbc:<datdbaseType>://host:port/<databaseName>?user=xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99

            //2.创建连接
            String url="jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99";
            Connection connection= DriverManager.getConnection(url);

            //3.创建命令
            Statement statement=connection.createStatement();  //connection的静态方法来获取对象
            //4.准备sql语句  避险*的存在
            String sql="select id,name,created_time,modify_time from memo_group";
            //5.执行语句
            ResultSet resultSet=statement.executeQuery(sql);  //statement对象方法来获取对象
            //6.处理数据

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                Timestamp created_time=resultSet.getTimestamp("created_time");
                Timestamp modify_time=resultSet.getTimestamp("modify_time");
                System.out.println(id);
                System.out.println(name);
                System.out.println(created_time);
                System.out.println(modify_time);

            }
            //7.关闭结果
            resultSet.close();
            //8.关闭命令
            statement.close();
            //9.关闭连接
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
