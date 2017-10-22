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

import com.luomengan.entity.Music;
import com.luomengan.pojo.DataResponse;
import com.luomengan.pojo.Response;
import com.luomengan.service.MusicService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 佛音 Controller
 * 
 * @author luomengan
 *
 */
@RestController
@RequestMapping("/music")
@Api(description = "佛音接口列表")
public class MusicController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public MusicService musicService;

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取佛音")
	public Response<Music> fetchById(@PathVariable Integer id) {
		return new Response<>(musicService.getMusicInfo(id));
	}

	@GetMapping("/page")
	@ApiOperation(value = "获取佛音分页数据", hidden = true)
	public Response<Page<Music>> musics(int page, int limit) {
		return new Response<>((Page<Music>) musicService.musics(page, limit));
	}

	@GetMapping("/list")
	@ApiOperation(value = "获取佛音列表", hidden = true)
	public Response<List<Music>> list() {
		return new Response<>(musicService.list());
	}

	@GetMapping("/pageByAlbumId")
	@ApiOperation(value = "根据专辑ID获取佛音列表")
	public Response<Page<Music>> pageByAlbumId(Integer albumId, Integer page, Integer limit) {
		return new Response<>(musicService.pageByAlbumId(albumId, page, limit));
	}
	
	@PostMapping("/play")
	@ApiOperation(value = "播放（用于增加播放次数）")
	public Response<String> play(int musicId) {
		musicService.play(musicId);
		return new Response<>("播放成功");
	}

	/******************************** 后台管理 **********************************/

	@PostMapping("/")
	@ApiOperation(value = "添加佛音", hidden = true)
	public Response<Music> addition(Music music) {
		return new Response<>(musicService.addMusic(music));
	}

	@PutMapping("/")
	@ApiOperation(value = "修改佛音", hidden = true)
	public Response<Music> modification(Music music) {
		return new Response<>(musicService.modifyMusic(music));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除佛音", hidden = true)
	public Response<Integer> delete(@PathVariable Integer id) {
		musicService.deleteMusic(id);
		return new Response<Integer>(id);
	}

	@PostMapping("/deletes")
	@ApiOperation(value = "批量删除佛音（多个id以逗号分割）", hidden = true)
	public Response<Boolean> deletes(String ids) {
		musicService.deleteMusics(ids);
		return new Response<Boolean>(true);
	}

	@GetMapping("/adminList")
	@ApiOperation(value = "获取佛音列表(后台管理)", hidden = true)
	public DataResponse<List<Music>> adminList() {
		return new DataResponse<>(musicService.list());
	}

}
