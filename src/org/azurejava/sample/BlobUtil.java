package org.azurejava.sample;

import java.net.URI;
import java.util.List;

import com.microsoft.windowsazure.services.core.storage.*;
import com.microsoft.windowsazure.services.blob.client.*;

public class BlobUtil {
    public static final String storageConnectionString =
            "DefaultEndpointsProtocol=http;"
            + "AccountName=your_account_name;"
            + "AccountKey= your_account_key";
	  
	  public static String listContainers() {
          CloudStorageAccount account;
          CloudBlobClient serviceClient;

		  String bar = "";
		  
          try {
	          account = CloudStorageAccount.parse(storageConnectionString);
	          serviceClient = account.createCloudBlobClient();
	          // Container name must be lower case.
	          Iterable<CloudBlobContainer> listBlobContainers = serviceClient.listContainers();
	
			  for (CloudBlobContainer objBlobContainer : listBlobContainers ) {
		            bar += objBlobContainer.getName() + "<br />";
			  }
          } catch (Exception e) {
        	  System.out.print("Exception encountered: ");
              System.out.println(e.getMessage());
          }
          
		  return bar;
	  }
	  
	  public static boolean blobExists(String containerName, String blobName) {
          CloudStorageAccount account;
          CloudBlobClient serviceClient;
          CloudBlockBlob blob;
          
          try {
	          account = CloudStorageAccount.parse(storageConnectionString);
	          serviceClient = account.createCloudBlobClient();
			  CloudBlobContainer container = serviceClient.getContainerReference(containerName);
			  blob = container.getBlockBlobReference(blobName);
			  return true;
          } catch (Exception e) {
        	  System.out.print("Exception encountered: ");
              System.out.println(e.getMessage());
          }
          
		  return false;
	  }
}
