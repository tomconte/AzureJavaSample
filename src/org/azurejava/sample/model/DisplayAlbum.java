package org.azurejava.sample.model;

public class DisplayAlbum {
	private int albumId;
	private String title;
	private String cover;
	private boolean hasCover = false;
	
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
	
	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}

	public boolean hasCover() {
		return hasCover;
	}

	public void setHasCover(boolean hasCover) {
		this.hasCover = hasCover;
	}
}
