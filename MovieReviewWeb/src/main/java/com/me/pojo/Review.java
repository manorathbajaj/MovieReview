package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reviewID", unique = true, nullable = false)
	private long reviewID;
	
	@ManyToOne
	@JoinColumn(name = "personID")
	private User postedBy;
	
	@ManyToOne
	@JoinColumn(name = "movieID")
	private Movie movie;
	
	@Column(name="star")
	private int star;
	
	@Column(name="comment")
	private String comment;
	
	public Review() {
	}
	
	public Review(User postByUser, Movie movie, int star, String comment) {
		this.postedBy = postByUser;
		this.movie = movie;
		this.star = star;
		this.comment = comment;
	}



	public long getReviewID() {
		return reviewID;
	}



	public void setReviewID(long reviewID) {
		this.reviewID = reviewID;
	}



	
	
	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public Movie getMovie() {
		return movie;
	}

	

	public void setMovie(Movie movie) {
		this.movie = movie;
	}



	public int getStar() {
		return star;
	}



	public void setStar(int star) {
		this.star = star;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}


}
