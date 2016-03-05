package javaapplication3;

import java.util.EventObject;
import java.io.BufferedReader;
import com.amazonaws.auth.BasicAWSCredentials;
import java.io.File;
import java.lang.Object;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.UUID;
import java.lang.String;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.eclipse.simpleworkflow.asynchrony.annotationprocessor.AsynchronyDeciderAnnotationProcessor;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.RequestClientOptions;
import java.io.*;

public class JavaApplication5 {


    public static void main(String[] args) throws IOException{
String ch;
        InputStreamReader ip= new InputStreamReader(System.in);
      BufferedReader reader=new BufferedReader(ip);
    AmazonOp A1=new AmazonOp();
    
        do
        {
            System.out.println("\n-c.Create Bucket\n-u.Uplaod\n-d.Delete\n-e.Exit");
            System.out.println("\nEnter your choice : ");
            ch =  reader.readLine();
            switch(ch)
            {
                case "-c" :
                            A1.createBucket();
                            break;
                case "-u" :
                            A1.upload();
                            break;
                case "-d" : 
                           A1.deletb(); 
                            break;
                case "-e" :
                           System.exit(0);
                           break;
            }
            
        }while(!"-e".equals(ch));
        /*AWSCredentials myCredentials = new BasicAWSCredentials(
                                       "AKIAJA24LJKZZKG6K6PA", "qblG/Nv1XtkuxSaZd/InU22OxIOuvtCGndWKEHlk");
AmazonS3 s3client = new AmazonS3Client(myCredentials);   
              

        s3client.createBucket("mprs12345") ;*/
        //s3client.deleteBucket("mprs123");
        
       /* String bucketName     = "mprs12345";
	String keyName        = "AKIAJA24LJKZZKG6K6PA";
        String uploadFileName = "E:\\Study Related\\Sampletest.txt";
        JavaApplication3.class.getResourceAsStream("keyName");
        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(uploadFileName);
            s3client.putObject(new PutObjectRequest(
            		                 bucketName, keyName, file));

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }*/
       }     
    };

class AmazonOp{
  String Akey,Skey,bname,path;
    
    InputStreamReader ip= new InputStreamReader(System.in);
      BufferedReader reader=new BufferedReader(ip);
  
  void getdetails() throws IOException{   
      
      System.out.println("\nEnter Access key : AKIAJA24LJKZZKG6K6PA :");
      Akey=reader.readLine();
          
      System.out.println("\nEnter Secret key : qblG/Nv1XtkuxSaZd/InU22OxIOuvtCGndWKEHlk ");
      Skey =reader.readLine();
      
      
      
       AWSCredentials myCredentials = new BasicAWSCredentials(
                                       Akey, Skey);       
       AmazonS3 s3client = new AmazonS3Client(myCredentials);
}
      void createBucket() throws IOException{
       getdetails();  
       System.out.println("\nEnter the name of the Bucket : ");
      bname =reader.readLine();
       AWSCredentials myCredentials = new BasicAWSCredentials(
                                       Akey, Skey);       
       AmazonS3 s3client = new AmazonS3Client(myCredentials);   

       s3client.createBucket(bname) ;
       System.out.println("\nBucket Created!!");
    //   upload(Akey,bname,myCredentials);
      }
  void upload() throws IOException{
   
      getdetails();
      System.out.println("\nEnter the name of the Bucket : ");
      bname =reader.readLine();
      System.out.println("Enter the path of the source file : ");
       path = reader.readLine();
       AWSCredentials myCredentials = new BasicAWSCredentials(
                                       Akey, Skey);       
      
       AmazonS3 s3client = new AmazonS3Client(myCredentials);  
      AmazonOp.class.getResourceAsStream("keyName");
        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            File file = new File(path);
            s3client.putObject(new PutObjectRequest(
            		                 bname, Akey, file));

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
  }
  
  void deletb() throws IOException{
      getdetails();
       AWSCredentials myCredentials = new BasicAWSCredentials(
                                       Akey, Skey);       
      
       AmazonS3 s3client = new AmazonS3Client(myCredentials);  
       System.out.println("\nEnter the name of the bucket to be deleted : ");
       String dbname = reader.readLine();
       s3client.deleteBucket(dbname);
  }
}