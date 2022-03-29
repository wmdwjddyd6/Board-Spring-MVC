package com.spring.shoppingmall.mapper;

import java.util.List;

import com.spring.shoppingmall.model.BoardDTO;

public interface BoardMapper {

	// 게시글 목록 조회
	List<BoardDTO> selectAll();
	
	// 게시글 등록
	int insertBoard(BoardDTO boardDTO);

	// 게시글 조회
	BoardDTO selectPost(Long boardId);
	
}