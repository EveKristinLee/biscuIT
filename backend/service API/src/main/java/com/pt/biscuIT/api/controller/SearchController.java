package com.pt.biscuIT.api.controller;

import java.util.List;

import com.pt.biscuIT.db.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pt.biscuIT.api.dto.content.ContentInfoDto;
import com.pt.biscuIT.api.response.SearchContentRes;
import com.pt.biscuIT.api.service.SearchService;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/search")
public class SearchController {

	private final SearchService searchService;

	@GetMapping("/{option}")
	public SearchContentRes search(
			@RequestParam String keyword,
			@RequestParam(required = false, defaultValue = "0") int from,
			@RequestParam(required = false, defaultValue = "1440") int to,
			@RequestParam(defaultValue = "999999") Long lastContentId,
			@PageableDefault(size = 30, page = 0) Pageable pageable,
			@RequestParam(defaultValue = "content") String condition,
			@RequestParam Type type,
			@PathVariable String option) {
		if(condition.equals("content")) {
			return searchService.searchContent(keyword, from, to, lastContentId, pageable, type, option);
		}
		else if(condition.equals("company")) {
			//todo: company 검색
			return null;
		}
		return null;
	}
}
