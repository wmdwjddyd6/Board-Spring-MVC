package com.spring.shoppingmall.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shoppingmall.mapper.BoardMapper;
import com.spring.shoppingmall.model.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int write(BoardDTO boardDTO) {
		boardDTO.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
		boardDTO.setType("board");
		return boardMapper.insertBoard(boardDTO);
	}
}