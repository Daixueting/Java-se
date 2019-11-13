package com.bittec;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: JdbcCase2
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/4
 **/
public class JdbcCase2 {
    /*
    * in 中不支持？表示多参数，字符串拼接，参数校验
    * */
    public static void main(String[] args) {
  List<Map<String,Object>> data= queryMemoGroup("jack");
        for (Map<String,Object> item:data
             ) {
            System.out.println(item);
        }
    }

    public static List<Map<String,Object>> queryMemoGroup(String groupNmae){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Map<String,Object>> list=new ArrayList<>(); //将命令传入到list类中
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //JDBC URL协议
            //jdbc:<datdbaseType>://host:port/<databaseName>?user=xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99

            //2.创建连接
            String url="jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99";
            connection= DriverManager.getConnection(url);

            String sql="select id,name,created_time,modify_time from memo_group where name=?";
            //3.创建命令---通过Connection对象，根据参数卷的SQL获取预编译命令
            preparedStatement=connection.prepareStatement(sql);
            //参数赋值，下标从一开始----看？个数的赋值
            preparedStatement.setString(1,groupNmae);
            //4.准备sql语句  避险*的存在
            //3.创建命令
            preparedStatement=connection.prepareStatement(sql);
            //5.执行语句
            resultSet=preparedStatement.executeQuery();
            //6.处理数据

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                Timestamp created_time=resultSet.getTimestamp("created_time");
                Timestamp modify_time=resultSet.getTimestamp("modify_time");
                Map<String,Object> row=new HashMap<>();
                row.put("id",id);
                row.put("name",name);
                row.put("created_time",created_time);
                row.put("modify_time",modify_time);
                list.add(row);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet!=null){
                //7.关闭结果
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                //8.关闭命令
                try {
                    preparedStatement.close();
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
        return list;
    }
}
