package org.internetprogramming.model;

public class SongBean {
	private String title;
	private String artist;
	private int ranking;
	private int year;
	public SongBean() {}
	public SongBean(String title, String artist, int ranking, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.ranking = ranking;
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "SongBean [title=" + title + ", artist=" + artist + ", ranking=" + ranking + ", year=" + year + "]";
	}
}
