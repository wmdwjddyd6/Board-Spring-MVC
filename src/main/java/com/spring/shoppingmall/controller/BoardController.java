package com.spring.shoppingmall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shoppingmall.model.BoardDTO;
import com.spring.shoppingmall.service.BoardService;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	/*
	 * 게시글 목록 화면 이동
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/board/list")
	public String list(Model model) {
		List<BoardDTO> boards = boardService.getList();
		model.addAttribute("boards", boards);

		return "board/list";
	}

	/*
	 * 게시글 상세 페이지 화면 이동
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/board/post")
	public String detailPost(Model model, @RequestParam(required = false) Long boardId) {
		BoardDTO boardDTO = boardService.getPost(boardId);
		model.addAttribute("board", boardDTO);
		
		return "board/post";
	}

	/*
	 * 게시글 작성 화면 이동
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/board/write")
	public String writeForm(Model model) {
		return "board/write";
	}

}
