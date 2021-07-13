package fr.jdr.spring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Document
@Data
public class UserFriends {
	@Id
	private Long id;

	
	@DBRef
	private User users;

}
