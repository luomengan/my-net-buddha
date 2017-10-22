package com.luomengan.pojo;

import com.luomengan.entity.MusicCategory;

public class MusicCategoryInfo extends MusicCategory {

	private boolean currentUserFavourite;

	private Integer userFavouriteCount;

	private Double avgRating;

	private Integer userRatingCount;

	public Integer getUserFavouriteCount() {
		return userFavouriteCount;
	}

	public void setUserFavouriteCount(Integer userFavouriteCount) {
		this.userFavouriteCount = userFavouriteCount;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public Integer getUserRatingCount() {
		return userRatingCount;
	}

	public void setUserRatingCount(Integer userRatingCount) {
		this.userRatingCount = userRatingCount;
	}

	public boolean isCurrentUserFavourite() {
		return currentUserFavourite;
	}

	public void setCurrentUserFavourite(boolean currentUserFavourite) {
		this.currentUserFavourite = currentUserFavourite;
	}

}
