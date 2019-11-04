package com.bittec;

import java.sql.*;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: JdbcCase1
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/4
 **/
public class JdbcCase1 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //JDBC URL协议
            //jdbc:<datdbaseType>://host:port/<databaseName>?user=xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99

            //2.创建连接
            String url="jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99";
            connection= DriverManager.getConnection(url);

            //3.创建命令
             statement=connection.createStatement();
            //4.准备sql语句  避险*的存在
            String sql="select id,name,created_time,modify_time from memo_group";
            //5.执行语句
            resultSet=statement.executeQuery(sql);
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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                //7.关闭结果
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           if (statement!=null){
               //8.关闭命令
               try {
                   statement.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if (connection!=null){
               //9.关闭连接
               try {
                   connection.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }

        }
    }
}
  //关闭接口AutoCloseable