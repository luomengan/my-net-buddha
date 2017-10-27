package com.luomengan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luomengan.entity.MusicCategory;
import com.luomengan.entity.UserFavourite;
import com.luomengan.entity.UserRating;
import com.luomengan.pojo.DataResponse;
import com.luomengan.pojo.MusicCategoryInfo;
import com.luomengan.security.SecurityUtil;
import com.luomengan.service.MusicCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 佛音类别 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/musicCategory")
@Api(description = "佛音类别接口列表")
public class MusicCategoryController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public MusicCategoryService musicCategoryService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取佛音类别")
	public DataResponse<MusicCategory> fetchById(@PathVariable Integer id) {
		return new DataResponse<>(musicCategoryService.getMusicCategoryInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取佛音类别分页数据", hidden = true)
	public DataResponse<Page<MusicCategory>> musicCategorys(int page, int limit) {
		return new DataResponse<>((Page<MusicCategory>) musicCategoryService.musicCategorys(page, limit));
	}

	@GetMapping("/list")
	@ApiOperation(value = "获取佛音类别列表", hidden = true)
	public DataResponse<List<MusicCategory>> list() {
		return new DataResponse<>(musicCategoryService.list());
	}

	@GetMapping("/listTopCategory")
	@ApiOperation(value = "获取佛音顶级类别列表")
	public DataResponse<List<MusicCategory>> listTopCategory() {
		return new DataResponse<>(musicCategoryService.listTopCategory());
	}

	@GetMapping("/pageAlbumByParentId")
	@ApiOperation(value = "获取顶级类别ID获取专辑列表")
	public DataResponse<Page<MusicCategoryInfo>> pageAlbumByParentId(Integer parentId, Integer page, Integer limit) {
		return new DataResponse<>(
				musicCategoryService.pageAlbumByParentId(SecurityUtil.getUserId(), parentId, page, limit));
	}
	
	@PostMapping("/userFavourite")
	@ApiOperation(value = "用户收藏专辑")
	public DataResponse<UserFavourite> userFavourite(Integer albumId) {
		return new DataResponse<>(musicCategoryService.userFavourite(SecurityUtil.getUserId(), albumId));
	}
	
	@PostMapping("/userRating")
	@ApiOperation(value = "用户评分专辑")
	public DataResponse<UserRating> userRating(Integer albumId, double rating) {
		return new DataResponse<>(musicCategoryService.userRating(SecurityUtil.getUserId(), albumId, rating));
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加佛音类别", hidden = true)
	public DataResponse<MusicCategory> addition(MusicCategory musicCategory) {
		return new DataResponse<>(musicCategoryService.addMusicCategory(musicCategory));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改佛音类别", hidden = true)
	public DataResponse<MusicCategory> modification(MusicCategory musicCategory) {
		return new DataResponse<>(musicCategoryService.modifyMusicCategory(musicCategory));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除佛音类别", hidden = true)
	public DataResponse<Integer> delete(@PathVariable Integer id) {
		musicCategoryService.deleteMusicCategory(id);
		return new DataResponse<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除佛音类别（多个id以逗号分割）", hidden = true)
	public DataResponse<Boolean> deletes(String ids) {
		musicCategoryService.deleteMusicCategorys(ids);
		return new DataResponse<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取佛音类别列表(后台管理)", hidden = true)
	public DataResponse<List<MusicCategory>> adminList() {
		return new DataResponse<>(musicCategoryService.list());
	}

}
