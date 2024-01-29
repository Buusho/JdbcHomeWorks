package org.example;

import Models.Users;
import Services.Impl.UserServiceIml;
import Services.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        UserService userService = new UserServiceIml();
//        System.out.println(userService.createUserTable());
//        System.out.println(userService.saveUser(new Users("Adyl","Tolomushev", (byte) 2005)));
//        System.out.println(userService.saveUser(new Users("Arslan","Alymkulov", (byte) 2005)));
      System.out.println(userService.saveUser(new Users("Argen","Taalibekov", (byte) 2005)));
//        System.out.println(userService.findUserById(1L));
//        System.out.println(userService.deleteUserById(3L));
//        System.out.println(userService.findAllUsers());





    }
}
