package com.spring.shoppingmall.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shoppingmall.mapper.BoardMapper;
import com.spring.shoppingmall.model.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override
	public List<BoardDTO> getList() {
		List<BoardDTO> list = boardMapper.selectAll();
		
		return list;
	}
	
	@Override
	public int write(BoardDTO boardDTO) {
		boardDTO.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
		boardDTO.setType("board");
		
		return boardMapper.insertBoard(boardDTO);
	}

	@Override
	public BoardDTO getPost(Long boardId) {
		BoardDTO boardDTO = boardMapper.selectPost(boardId);
		
		return boardDTO;
	}

}