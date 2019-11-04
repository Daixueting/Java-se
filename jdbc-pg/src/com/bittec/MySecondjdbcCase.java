package com.bittec;

import java.sql.*;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: jdbc
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/4
 **/
public class MySecondjdbcCase {
    public static void main(String[] args) {
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
            Statement statement=connection.createStatement();
            //4.准备sql语句  避险*的存在
            String sql="insert into memo_group(name,created_time) values('tom','2019-06-14 19:42:00')";
            //5.执行语句
            int effect=statement.executeUpdate(sql);
            //6.处理数据
            System.out.println(effect);

            //7.关闭结果
           // resultSet.close();
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
