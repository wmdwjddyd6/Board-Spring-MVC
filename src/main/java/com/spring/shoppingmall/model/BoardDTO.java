package com.spring.shoppingmall.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BoardDTO {
	private Long id;
	private String title;
	private String content;
	private String deleteYn;
	private Timestamp createDate;
	private Long views;
	private String type;
}
