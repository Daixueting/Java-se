package com.bittec;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * @PACKAGE_NAME: com.bittec
 * @NAME: JdbcCase4
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/11/6
 **/
public class JdbcCase4 {
    public static void main(String[] args) {
        MemoGroup memoGroup=new MemoGroup();
        memoGroup.setId(666);
        memoGroup.setName("测试组");
        memoGroup.setCreatedTime(LocalDateTime.now());
        MemoInfo memoInfo=new MemoInfo();
        memoInfo.setId(10);
        memoInfo.setGroup_id(memoGroup.getId());
        memoInfo.setTitle("今天是个好日子");
        memoInfo.setContent("----");
        memoInfo.setCreatedTine(LocalDateTime.now());

        boolean rs=createdMemoInfo(memoGroup,memoInfo);
        if (rs){
            System.out.println("创建便签成功");
        }else {
            System.out.println("创建标签失败");
        }
    }

    public static boolean createdMemoInfo(MemoGroup memoGroup,MemoInfo memoInfo){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url="jdbc:mysql://127.0.0.1:3306/memo?user=root&password=daixueting52o99";
        Connection connection=null;
        try{
            connection = DriverManager.getConnection(url);
           //事务控制--setAutoCommit类
            connection.setAutoCommit(false); //--true表示会自动提
            String memoGroupInsertSql="insert into memo_group(id,name,created_time) values(?,?,?)";
            String memoInfoInsertSql="insert into memo_info(id,group_id,title,content,created_time) values (?,?,?,?,?)";
            int effctA=0;
            int effctB=0;
            try (PreparedStatement statement=connection.prepareStatement(memoGroupInsertSql)){
                statement.setInt(1,memoGroup.getId());
                statement.setString(2,memoGroup.getName());
                statement.setTimestamp(3, (Timestamp.valueOf(memoGroup.getCreatedTime())));
                effctA=statement.executeUpdate();
            }
            try (PreparedStatement statement=connection.prepareStatement(memoInfoInsertSql)){
                statement.setInt(1,memoInfo.getId());
                statement.setInt(2,memoInfo.getGroup_id());
                statement.setString(3, memoInfo.getTitle());
                statement.setString(4, memoInfo.getContent());
                statement.setTimestamp(5, Timestamp.valueOf(memoInfo.getCreatedTine()));

                effctB=statement.executeUpdate();
            }

            //正常执行完成之后，根据结果确定提交是否回滚
            if (effctA==1&&effctB==1){
                connection.commit();
                return true;
            }else {
                connection.rollback();
                return false;
            }

    } catch (SQLException e) {
            //执行失败
            if (connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}

class MemoInfo{
    private Integer id;
    private Integer group_id;
    private String title;
    private String content;
    private String isProtected;
    private Clor backgroung;
    private String isRemind;
    private  LocalDateTime remindTime;
    private  LocalDateTime createdTine;
    private  LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(String isProtected) {
        this.isProtected = isProtected;
    }

    public Clor getBackgroung() {
        return backgroung;
    }

    public void setBackgroung(Clor backgroung) {
        this.backgroung = backgroung;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind;
    }

    public LocalDateTime getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(LocalDateTime remindTime) {
        this.remindTime = remindTime;
    }

    public LocalDateTime getCreatedTine() {
        return createdTine;
    }

    public void setCreatedTine(LocalDateTime createdTine) {
        this.createdTine = createdTine;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoInfo{" +
                "id=" + id +
                ", group_id=" + group_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isProtected='" + isProtected + '\'' +
                ", backgroung=" + backgroung +
                ", isRemind='" + isRemind + '\'' +
                ", remindTime=" + remindTime +
                ", createdTine=" + createdTine +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

enum Clor{
    WHITE,BLUE,GREEN,RED;
}