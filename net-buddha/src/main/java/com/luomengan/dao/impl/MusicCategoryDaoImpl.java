package com.luomengan.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.luomengan.dao.DynamicQuerySqlDao;
import com.luomengan.dao.MusicCategoryDao;
import com.luomengan.dao.impl.jpa.MusicCategoryRepository;
import com.luomengan.entity.MusicCategory;
import com.luomengan.pojo.MethodDesc;
import com.luomengan.pojo.MusicCategoryInfo;

/**
 * 佛音类别 Dao实现
 * 
 * @author luomengan
 *
 */
@Repository
public class MusicCategoryDaoImpl implements MusicCategoryDao {

	@Autowired
	private MusicCategoryRepository musicCategoryRepository;
	@Autowired
	private DynamicQuerySqlDao sqlDao;

	@Override
	public MusicCategory createMusicCategory(MusicCategory musicCategory) {
		return musicCategoryRepository.save(musicCategory);
	}

	@Override
	public void deleteMusicCategoryById(Integer id) {
		musicCategoryRepository.delete(id);
	}

	@Override
	public MusicCategory updateMusicCategory(MusicCategory musicCategory) {
		return musicCategoryRepository.save(musicCategory);
	}

	@Override
	public MusicCategory retrieveMusicCategoryById(Integer id) {
		return musicCategoryRepository.findById(id);
	}

	@Override
	public Page<MusicCategory> pageMusicCategory(int page, int limit) {
		return musicCategoryRepository.findAll(new PageRequest(page, limit));
	}

	@Override
	public List<MusicCategory> listMusicCategory() {
		return musicCategoryRepository.findAll();
	}

	@Override
	public List<MusicCategory> listMusicCategoryByLevel(Integer level) {
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "sortNum"));
		return musicCategoryRepository.findByLevel(level, sort);
	}

	@Override
	public Page<MusicCategory> pageMusicCategoryByParentId(Integer parentId, Integer page, Integer limit) {
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "sortNum"));
		Pageable pageable = new PageRequest(page, limit, sort);
		return musicCategoryRepository.findByParentId(parentId, pageable);
	}

	@Override
	public Page<MusicCategoryInfo> sqlPageMusicCategoryByParentId(Integer parentId, Integer page, Integer limit) {
		String sql = String.format(
				"select t5.id, t5.author, t5.home_top_sort_num, t5.is_home_top, t5.is_recommend, t5.level, t5.name, t5.parent_id, t5.play_times, t5.sort_num, t5.txt_description, t5.user_favourite_count, t6.avg_rating, t6.user_rating_count from "
						+ "(select t1.*, count(t2.user_id) as user_favourite_count from t_music_category t1 LEFT JOIN t_user_favourite t2 on t2.resource_id=t1.id and t2.favourite_type=2 group by t1.id) t5 LEFT JOIN "
						+ "(select t3.*, IFNULL(avg(t4.rating), 0) as avg_rating, count(t4.user_id) as user_rating_count from t_music_category t3 LEFT JOIN t_user_rating t4 on t4.resource_id=t3.id and t4.rating_type=2 group by t3.id) t6 on t5.id=t6.id "
						+ "where t5.parent_id=%s order by t5.sort_num desc limit %s, %s",
				parentId, page * limit, limit);

		Map<Integer, MethodDesc> setMethodMap = new HashMap<>();
		setMethodMap.put(new Integer(0), new MethodDesc("setId", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(1), new MethodDesc("setAuthor", new Class<?>[] { String.class }));
		setMethodMap.put(new Integer(2), new MethodDesc("setHomeTopSortNum", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(3), new MethodDesc("setIsHomeTop", new Class<?>[] { Boolean.class }));
		setMethodMap.put(new Integer(4), new MethodDesc("setIsRecommend", new Class<?>[] { Boolean.class }));
		setMethodMap.put(new Integer(5), new MethodDesc("setLevel", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(6), new MethodDesc("setName", new Class<?>[] { String.class }));
		setMethodMap.put(new Integer(7), new MethodDesc("setParentId", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(8), new MethodDesc("setPlayTimes", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(9), new MethodDesc("setSortNum", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(10), new MethodDesc("setTxtDescription", new Class<?>[] { String.class }));
		setMethodMap.put(new Integer(11), new MethodDesc("setUserFavouriteCount", new Class<?>[] { Integer.class }));
		setMethodMap.put(new Integer(12), new MethodDesc("setAvgRating", new Class<?>[] { Double.class }));
		setMethodMap.put(new Integer(13), new MethodDesc("setUserRatingCount", new Class<?>[] { Integer.class }));
		List<MusicCategoryInfo> content = sqlDao.execute(MusicCategoryInfo.class, sql, setMethodMap);
		return new PageImpl<>(content, new PageRequest(page, limit), 0);
	}

}
