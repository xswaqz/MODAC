package com.a608.modac.model.room;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.a608.modac.model.chatting.ChatRoom;
import com.a608.modac.model.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name="max_size")
	private Integer maxSize;
	@Column(name="multi_theme")
	private String multiTheme;
	@Column(name="public_type")
	private Integer publicType;
	@Column(name="invitation_code")
	private String invitationCode;

	@ManyToOne
	@JoinColumn(name="users_seq")
	private User user;

	@OneToOne
	@JoinColumn(name = "chat_rooms_seq")
	private ChatRoom chatRoom;

	@Builder
	public Room(Long seq, String title, String description, Integer maxSize, String multiTheme, Integer publicType,
		String invitationCode, User user, ChatRoom chatRoom) {
		this.seq = seq;
		this.title = title;
		this.description = description;
		this.maxSize = maxSize;
		this.multiTheme = multiTheme;
		this.publicType = publicType;
		this.invitationCode = invitationCode;
		this.user = user;
		this.chatRoom = chatRoom;
	}

	public void updateRoom(final String title, final String description, final String multiTheme){
		this.title = title;
		this.description = description;
		this.multiTheme = multiTheme;
	}

}
