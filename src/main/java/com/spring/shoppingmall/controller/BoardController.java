package com.spring.shoppingmall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shoppingmall.model.BoardDTO;
import com.spring.shoppingmall.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	/*
	 * 게시글 작성 화면 이동
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/board/write")
	public String writeForm(Model model) {
		return "board/write";
	}
	
	/*
	 * 게시글 작성
	 * */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/board/write")
	public int write(Model model, BoardDTO boardDTO) {
		logger.debug("게시글 작성 호출");
		
		int result = 0;
		result = boardService.write(boardDTO);
		logger.debug("result is {}", result);
		
		return result;
	}
}
