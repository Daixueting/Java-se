package com.bittec;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: JdbcCase3
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/6
 **/
public class JdbcCase3 {
    public static void main(String[] args) {
        Integer id=1;
        String name="jack";
        List<MemoGroup> memoGroups=queryMemoGroup(id,name);
        for (MemoGroup memogroup:memoGroups
             ) {
            System.out.println(memogroup);
        }
    }
    public static List<MemoGroup> queryMemoGroup(Integer id,String name){
        List<MemoGroup> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(
                Connection connection= DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99");
                PreparedStatement statement=connection.prepareStatement("select id,name,created_time,modify_time " +
                        "from memo_group where id=? or name=?")
                ) {
                     statement.setString(1,name);
                     statement.setInt(2,id);
                     try (ResultSet resultSet=statement.executeQuery()){
                         while (resultSet.next()){
                             MemoGroup memoGroup=new MemoGroup();
                             memoGroup.setId(resultSet.getInt("id"));
                             memoGroup.setName(resultSet.getString("name"));
                             memoGroup.setCreatedTime(resultSet.getTimestamp("created_time").toLocalDateTime());
                             memoGroup.setModifyTime(resultSet.getTimestamp("modify_time").toLocalDateTime());


                             list.add(memoGroup);
                         }
                     }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
//跟数据库表关联的Java类称之为Entity类
class MemoGroup{
    private Integer id;
    private String name;
    private LocalDateTime createdTime;
    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}