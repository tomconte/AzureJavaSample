package org.azurejava.sample;

import java.net.URI;
import java.util.List;

import org.soyatec.windowsazure.blob.*;

public class BlobUtil {
	  //protected static final String BLOB_HOST_NAME      = "http://blob.core.windows.net/";
	  //protected static final String AZURE_ACCOUNT_NAME  = "tcontepub";
	  //protected static final String AZURE_ACCOUNT_KEY   = "wbhiBBPzQ1ExHUHuYpOzL1mIMvvyr4fSxNfwcOL0F12RfMAOheH87HMgl9vG1rNRaJpOLPehpN7sSO2UjUuqeQ==";
	  //protected static final boolean PATH_STYLE_URIS	= false;
	  protected static final String BLOB_HOST_NAME      = "http://127.0.0.1:10000/";
	  protected static final String AZURE_ACCOUNT_NAME  = "devstoreaccount1";
	  protected static final String AZURE_ACCOUNT_KEY   = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
	  protected static final boolean PATH_STYLE_URIS	= true;
	  
	  public static String listContainers() {
		  BlobStorageClient storageClient = BlobStorageClient.create(
				  URI.create(BLOB_HOST_NAME), 
				  PATH_STYLE_URIS, 
				  AZURE_ACCOUNT_NAME, 
				  AZURE_ACCOUNT_KEY);
		  
		  List<IBlobContainer> listBlobContainers = storageClient.listBlobContainers();

		  String bar = "";
		  
		  for (IBlobContainer objBlobContainer : listBlobContainers ) {
	            bar += objBlobContainer.getName() + "<br />";
		  }
		  
		  return bar;
	  }
	  
	  public static boolean blobExists(String containerName, String blobName) {
		  BlobStorageClient storageClient = BlobStorageClient.create(
				  URI.create(BLOB_HOST_NAME),
				  PATH_STYLE_URIS,
				  AZURE_ACCOUNT_NAME,
				  AZURE_ACCOUNT_KEY);
		  
		  IBlobContainer container = storageClient.getBlobContainer(containerName);
		  
		  return container.isBlobExist(blobName);
	  }
}
