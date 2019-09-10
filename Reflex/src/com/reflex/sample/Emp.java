package com.reflex.sample;

/**
 * @PACKAGE_NAME: com.reflex.sample
 * @NAME: Emp
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/5
 **/
public class Emp {

    private  String name;
    private  String job;
    private  String skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
