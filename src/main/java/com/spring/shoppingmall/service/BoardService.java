package com.spring.shoppingmall.service;

import java.util.List;

import com.spring.shoppingmall.model.BoardDTO;

public interface BoardService {
	
	// 게시글 목록 확인
	List<BoardDTO> getList();
	
	// 게시글 작성
	int write(BoardDTO boardDTO);

}