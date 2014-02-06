package org.azurejava.sample;

import java.util.*;

import org.azurejava.sample.domain.*;
import org.azurejava.sample.model.DisplayAlbum;
import org.hibernate.Session;

public class AlbumService {
	protected static final String BLOB_HOST_NAME = "http://tcontepub.blob.core.windows.net/";
	protected static final String BLOB_CONTAINER_NAME = "ledzep";
	
	public List<DisplayAlbum> getAlbumsForArtist(String artistName) {
		List<DisplayAlbum> displayAlbums = new ArrayList<DisplayAlbum>();
		
    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	
        session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Album> albums = session.createQuery("from Album a where a.artist.name='" + artistName + "'").list();
        for (int i=0; i < albums.size(); i++) {
        	Album a = albums.get(i);
        	
        	String blobName = a.getTitle() + ".jpg";
        	String containerName = BLOB_CONTAINER_NAME;
        	String img = null;
        	
        	if (BlobUtil.blobExists(containerName, blobName)) {
            	img = BLOB_HOST_NAME + containerName + "/" + blobName;
        	}

        	DisplayAlbum da = new DisplayAlbum();
        	da.setTitle(a.getTitle());
        	da.setAlbumId(a.getAlbumId());
        	if (img != null) {
        		da.setCover(img);
        		da.setHasCover(true);
        	}
        	displayAlbums.add(da);
        }

        session.getTransaction().commit();
        
        return displayAlbums;
	}

}
