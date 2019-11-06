package com.bittec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: JdbcTemplate
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/5
 **/
public class JdbcTemplate extends AbstractJdbcTemplate {
    @Override
    public <T> T handlerResult(ResultSet resultSet) {
        StringBuilder stringBuilder=new StringBuilder();
        try {
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                Timestamp created_time=resultSet.getTimestamp("created_time");
                Timestamp modify_time=resultSet.getTimestamp("modify_time");
              stringBuilder.append(id+" "+name+" "+created_time+" "+" "+modify_time);
              stringBuilder.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) stringBuilder.toString();
    }

    @Override
    public <T> T handlerResult(int effect) {
        return (T) Integer.valueOf(effect);
    }

    public static void main(String[] args) {
        AbstractJdbcTemplate template=new JdbcTemplate();
        String rs=template.execute("select id,name,created_time,modify_time from memo_group");
        System.out.println(rs);
    }
}
