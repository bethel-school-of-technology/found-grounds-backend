package com.foundgrounds.comments;


import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private String text;
    private Boolean deleted; 
    private Date timePosted;
    
    
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Date getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
    
    
}
