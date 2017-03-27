package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by yyy on 2017/3/10.
 */
public interface UserDao extends JpaRepository<User,Serializable> {

    User findById(int id);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findByCardId(String cardId);


}
