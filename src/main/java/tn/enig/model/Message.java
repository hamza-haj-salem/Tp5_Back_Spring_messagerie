package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sujet;
	private String contenu;
	@ManyToOne 
	@JoinColumn(name="userSend_id")
	private User userSend;
	@ManyToOne 
	@JoinColumn(name="userReceive_id")
	private User userReceive;
	public Message() {
		super();
	}
	public Message(Integer id, String sujet, String contenu, User userSend, User userReceive) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.contenu = contenu;
		this.userSend = userSend;
		this.userReceive = userReceive;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public User getUserSend() {
		return userSend;
	}
	public void setUserSend(User userSend) {
		this.userSend = userSend;
	}
	public User getUserReceive() {
		return userReceive;
	}
	public void setUserReceive(User userReceive) {
		this.userReceive = userReceive;
	}
	
	
	

}
