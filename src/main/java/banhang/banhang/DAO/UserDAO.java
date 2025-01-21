package banhang.banhang.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import banhang.banhang.model.User;

public interface UserDAO extends JpaRepository<User, Long> {
}
