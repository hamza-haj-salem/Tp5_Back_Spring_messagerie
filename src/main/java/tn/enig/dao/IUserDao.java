package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enig.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.username=?1 and u.password=?2 ") 
	public User getUserByLoginAndPassword(String username, String password);
	
	@Query("select u from User u where u.username=?1 and u.password=?2 ") 
	public User getIdUserByLoginAndPassword(String username, String password);
	
	@Query("select u from User u where u.username=?1") 
	public User getUserByLogin(String username);

}
