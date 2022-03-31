package com.spring.shoppingmall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.shoppingmall.model.BoardDTO;
import com.spring.shoppingmall.service.BoardService;

/*
 * 게시판 화면 이동 및 CRUD에 관한 컨트롤러입니다.
 * rest api (게시글 작성, 수정, 삭제)의 경우 맨 아랫 줄의 코드입니다.
 * 
 * */
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
	 * 게시글 작성 & 수정 화면 이동
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/board/write")
	public String writeForm(Model model, @RequestParam(required = false) Long boardId) {
		if (boardId != null) {
			BoardDTO boardDTO = boardService.getPost(boardId);
			model.addAttribute("board", boardDTO);
		}

		return "board/write";
	}

	/*
	 * 게시글 작성
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/board")
	public int write(Model model, @RequestBody BoardDTO boardDTO) {
		logger.debug("게시글 작성 호출");

		int result = 0;
		result = boardService.write(boardDTO);
		logger.debug("result is {}", result);

		return result;
	}

	/*
	 * 게시글 수정
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PATCH, value = "/board/{boardId}")
	public int update(Model model, @RequestBody BoardDTO boardDTO, @PathVariable(value = "boardId") Long boardId) {
		logger.debug("{}번 게시글 수정 호출", boardId);

		int result = 0;
		result = boardService.update(boardDTO, boardId);
		logger.debug("result is {}", result);

		return result;
	}

}
