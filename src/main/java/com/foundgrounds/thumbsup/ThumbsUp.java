package com.foundgrounds.thumbsup;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thumbsUp")
public class ThumbsUp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer thumbsUpId;
	private Integer postId;
	private Integer userId;
	private Boolean thumbsUp;
	
	
	public Integer getThumbsUpId() {
		return thumbsUpId;
	}
	public void setThumbsUpId(Integer thumbsUpId) {
		this.thumbsUpId = thumbsUpId;
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
	public Boolean getThumbsUp() {
		return thumbsUp;
	}
	public void setThumbsUp(Boolean thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

}
