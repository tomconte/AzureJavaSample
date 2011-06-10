package org.azurejava.sample;

import java.util.*;

import org.azurejava.sample.domain.*;
import org.azurejava.sample.model.DisplayAlbum;
import org.hibernate.Session;

public class AlbumService {
	
	public List<DisplayAlbum> getAlbumsForArtist(String artistName) {
		List<DisplayAlbum> displayAlbums = new ArrayList<DisplayAlbum>();
		
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	
        session.beginTransaction();

		List albums = session.createQuery("from Album a where a.artist.name='" + artistName + "'").list();
        for (int i=0; i < albums.size(); i++) {
        	Album a = (Album)albums.get(i);
        	
        	String blobName = a.getTitle() + ".jpg";
        	String containerName = "ledzep";
        	String img = null;
        	
        	if (BlobUtil.blobExists(containerName, blobName)) {
            	img = "http://tcontepub.blob.core.windows.net/" + containerName + "/" + blobName;
        	}

        	DisplayAlbum da = new DisplayAlbum();
        	da.setTitle(a.getTitle());
        	da.setAlbumId(a.getAlbumId());
        	if (img != null) {
        		da.setCover(img);
        	}
        	displayAlbums.add(da);
        }

        session.getTransaction().commit();
        
        return displayAlbums;
	}

}
