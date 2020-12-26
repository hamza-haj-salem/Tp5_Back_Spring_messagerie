package tn.enig.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enig.dao.IMessageDao;
import tn.enig.dao.IUserDao;
import tn.enig.model.Message;
import tn.enig.model.User;

@CrossOrigin("*")
@RestController
public class ServiceRestMessagerie {
	
	@Autowired
	private IUserDao daou;
	@Autowired
	private IMessageDao daom;
	
	public void setDaom(IMessageDao daom) {this.daom = daom;}
	public void setDaou(IUserDao daou) { this.daou = daou;}
	
	@GetMapping("/listeUser")
	public  List<User> fct1(){
		return daou.findAll();
	}
	
	@PostMapping("/verifUser")
	public User verifUser(@RequestBody User u) {
		User u2 = null;
		u2= daou.getUserByLoginAndPassword(u.getUsername(), u.getPassword());
		if(u2 != null) {
			return u2;
		}else return null;
	}
	
	@PostMapping("/idUser")
	public int getIdUser(@RequestBody User u) {
		User u2 = null;
		
		u2= daou.getIdUserByLoginAndPassword(u.getUsername(), u.getPassword());
		if(u2 != null) {
			return u2.getId();
		}else return (Integer) null;
		
	}
	
	@GetMapping("/listMessageByUserReceive/{idUser}")
	public List <Message> ListMessageByUserReceive(@PathVariable("idUser") int idUser){
		return (List<Message>) daom.getMessageByUserReceive(idUser);
	}
	
	@GetMapping("/listMessageByUserSend/{idUser}")
	public List <Message> ListMessageByUserSend(@PathVariable("idUser") int idUser){
		return (List<Message>) daom.getMessageByUserSend(idUser);
	}
	
	@DeleteMapping("/deleteMsg/{idMsg}")
	public void deleteMessageById(@PathVariable("idMsg") int idMsg) {
		daom.deleteById(idMsg);
	}
	
	@GetMapping("/userByLogin/{u}")
	public User getUserByLogin(@PathVariable String u) {
		User u2 = null;
		u2= daou.getUserByLogin(u);
		if(u2 != null) {
			return u2;
		}else return null;
	}
	
	@GetMapping("/listeMsg")
	public  List<Message> fct10(){
		return daom.findAll();
	}
	
	@PostMapping("/sendMessage")
	public void sendMsg(@RequestBody Message m) {
		daom.save(m);
	}
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User u) {
		daou.save(u);
	}
}
