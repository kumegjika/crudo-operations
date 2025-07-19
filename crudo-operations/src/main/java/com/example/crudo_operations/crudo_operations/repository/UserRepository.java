package com.example.crudo_operations.crudo_operations.repository;

import com.example.crudo_operations.crudo_operations.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//shtresa  qe eshte  epergjegjshme per manipulimmin  eete dhenave
@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    //zakonish perdoret nje repository pe rte riuajtur users
    //duke qene se nuk kemi databaze  e stimulojme vete ketet organizem


    private Long nextID = 1L;

    //metode qe kthen te gjitha users

    public  List<User> findAll(){
        return new ArrayList<>(users);

    }

    //gjej user sipas id

     public Optional <User> findById(Long id){
        return users.stream()
                .filter(user ->  user.getId().equals(id))
                .findFirst();
     }

     // kemi ruajtjen  enje user

    public User save(User user){
        user.setId(nextID++);//i vendos perdoruesit nje id unike
        users.add(user);
        return user;
    }
    //fshirje  enje useri
    public void deleteById(Long id){
        users.removeIf(user -> user.getId().equals(id));

    }

    //update i nje user

    public User update (Long id, User updateUser){
        Optional<User> existingUser = findById(id);
        if (existingUser.isPresent()){
            User existingOptUser = existingUser.get();
            existingOptUser.setName(updateUser.getName());
            existingOptUser.setEmail(updateUser.getEmail());
            return existingOptUser;

        }
        return null;
    }

}
