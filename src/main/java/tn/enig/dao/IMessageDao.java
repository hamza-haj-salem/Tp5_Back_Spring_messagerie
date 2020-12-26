package tn.enig.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.enig.model.Message;
import tn.enig.model.User;

@Repository
public interface IMessageDao extends JpaRepository<Message, Integer> {
	
	@Query("select m from Message m where m.userReceive.id=?1") 
	public List <Message> getMessageByUserReceive(int id); 
	
	@Query("select m from Message m where m.userSend.id=?1") 
	public List <Message> getMessageByUserSend(int id); 

}
