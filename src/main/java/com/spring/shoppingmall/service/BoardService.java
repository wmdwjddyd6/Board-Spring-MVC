package com.spring.shoppingmall.service;

import com.spring.shoppingmall.model.BoardDTO;

public interface BoardService {
	
	// 게시글 작성
	int write(BoardDTO boardDTO);
}