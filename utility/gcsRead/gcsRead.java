package utility.gcsRead;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.nio.file.Path;
import java.nio.file.Paths;

public class gcsRead {

    public static void main(String[]args){
        String projectId = "";

        // The ID of your GCS bucket
         String bucketName = "";
    
        // The ID of your GCS object
         String objectName = "";
    
        // The path to which the file should be downloaded
         Path destFilePath = Paths.get("C:/SSDP Repo/ssdp/ssdp-Automation/ImagesCompare/bucket");
    
        downloadObject(projectId, bucketName, objectName, destFilePath);
        
        
    }
  public static void downloadObject(
      String projectId, String bucketName, String objectName, Path destFilePath) {
    // The ID of your GCP project
   
    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Blob blob = storage.get(BlobId.of(bucketName, objectName));
    blob.downloadTo(destFilePath);

    System.out.println("Downloaded object "+ objectName+ " from bucket name "+ bucketName + " to "+ destFilePath);
  }
}