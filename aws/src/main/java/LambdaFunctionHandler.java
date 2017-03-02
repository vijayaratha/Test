
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;

public class LambdaFunctionHandler implements RequestHandler<S3Event, Object> {

    public Object handleRequest(S3Event input, Context context) {

        context.getLogger().log("Input--: " + input);

        String bucketName = input.getRecords().get(0).getS3().getBucket().getName();
        String fileName =  input.getRecords().get(0).getS3().getObject().getKey();
        
        context.getLogger().log("fileName: " + fileName+" bucketname :"+ bucketName );
        
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTP);
      //  AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
        
        AmazonS3 client = new AmazonS3Client();

        
        S3Object xFile = client.getObject(bucketName, fileName);
        InputStream contents = xFile.getObjectContent();
        context.getLogger().log("file Content---" + contents);
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(contents));

        String line;

        try {
            while ((line = reader.readLine()) != null) {

                context.getLogger().log(line);

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
