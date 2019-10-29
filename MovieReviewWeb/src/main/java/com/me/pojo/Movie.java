package com.me.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieId", unique = true, nullable = false)
	private long movieId;
	@Column
	private String name;
	@Column
	private String actor;
	@Column
	private String actress;
	@Column
	private String genre;
	@Column
	private int year;
	@Column
	private String summary;
	
	@Transient
	private MultipartFile poster;
	
	public MultipartFile getPoster() {
		return poster;
	}
	public void setPoster(MultipartFile poster) {
		this.poster = poster;
	}
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Review> reviews= new HashSet<Review>();
	
	public String getSummary() {
		return summary;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActress() {
		return actress;
	}
	public void setActress(String actress) {
		this.actress = actress;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
}
