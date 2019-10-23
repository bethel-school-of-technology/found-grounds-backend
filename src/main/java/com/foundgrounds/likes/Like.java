package com.foundgrounds.likes;

import javax.persistence.*;

@Entity
@Table(name="Likes")
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer likeId;
	private Integer postId;
	private Integer userId;
	private Boolean like;
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Boolean getLike() {
		return like;
	}
	public void setLike(Boolean like) {
		this.like = like;
	}
}
