package org.azurejava.sample.domain;

public class Album {
	private int albumId;
	private String title;
	private Artist artist;

	public int getAlbumId() {
		return albumId;
	}
	
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
}
