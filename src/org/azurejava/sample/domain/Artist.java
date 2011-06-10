package org.azurejava.sample.domain;

import java.util.Set;

public class Artist {
	private int artistId;
	private String name;
	private Set albums;
	
	public int getArtistId() {
		return artistId;
	}
	
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Set getAlbums() {
		return albums;
	}

	public void setAlbums(Set albums) {
		this.albums = albums;
	}
}
