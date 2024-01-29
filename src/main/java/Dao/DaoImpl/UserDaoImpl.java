package Dao.DaoImpl;

import Dao.UserDaoInterFace;
import Models.Users;
import jdbcConfig.jdbcConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDaoInterFace {
    private  final Connection connection = jdbcConfig.getConnection();
    @Override
    public boolean createUserTable() {
       int  execute = 0;
    String query = """
          create table if not exists users(
          id serial primary key ,
          first_name varchar ,
          last_name varchar ,
          age int );
        """;
    try(Statement statement = connection.createStatement()){
execute =statement.executeUpdate(query);


    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
        return execute == 0;
    }

    @Override
    public String saveUser(Users newUser) {
     String query = """
             insert into users (first_name,last_name,age)
             values (?, ?, ?);
             """;
            try (PreparedStatement  preparedStatement = connection.prepareStatement(query)){
preparedStatement.setString(1, newUser.getFirstName());
preparedStatement.setString(2, newUser.getLastName());
preparedStatement.setInt(3,newUser.getAge());
preparedStatement.executeUpdate();
return "user is saved ";
}catch (SQLException e){
                System.out.println(e.getMessage());
            }
        return "Filed";
    }

    @Override
    public Optional<Users> findById(long id) {
        Users users = new Users();
        String query = "select * from users where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                throw  new RuntimeException("User with id :"+id+"not found");
            }
            users.setId(resultSet.getLong("id"));
            users.setFirstName(resultSet.getString("first_name"));
            users.setLastName(resultSet.getString("last_name"));
            users.setAge((byte) resultSet.getLong("age"));
            resultSet.close();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


        return Optional.of(users);
    }





    @Override
    public   boolean deleteUserById(Long id) {
        String query ="delete from users where  id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,id);
            preparedStatement.execute();

        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }

return false ;
    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> userss = new ArrayList<>();

        String query = "select * from users;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
               Users users = new Users();
                users.setId(resultSet.getLong("id"));
               users.setFirstName(resultSet.getString("first_name"));
                users.setLastName(resultSet.getString("last_name"));
              users.setAge((byte) resultSet.getInt("age"));

                userss.add(users);
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userss;
    }
}
