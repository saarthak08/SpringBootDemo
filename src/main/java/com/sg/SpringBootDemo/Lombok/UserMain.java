package com.sg.SpringBootDemo.Lombok;

public class UserMain {
    public static void main(String[] args){
        User user=new User();
        User user1=new User("Saarthak",2000L,1);

        System.out.println(user1);
        System.out.println(user);

    }
}
