import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.google.gson.Gson;

/**
 * Sample Lambda function which generates notification to a topic, whenever a
 * new file saved in S3 store.
 * 
 *
 * @version $Rev$ $Date$
 */

public class LambdaToSNSHander implements RequestHandler<S3Event, Object> {

    private static final String KEYVALUE_SEPERATOR = ":";
    private static final String VALUE_SEPERATOR = ",";
    private static final String TOPIC =
        "arn:aws:sns:ap-southeast-2:593177897798:ratha";

    @Override
    public Object handleRequest(S3Event input, Context context) {
        String bucketName =
            input.getRecords().get(0).getS3().getBucket().getName();
        String fileName =
            input.getRecords().get(0).getS3().getObject().getKey();

        context.getLogger()
            .log("fileName: " + fileName + " bucketname :" + bucketName);

        AmazonS3 client = new AmazonS3Client();

        S3Object s3object = client.getObject(bucketName, fileName);
        InputStream contents = s3object.getObjectContent();

        BufferedReader reader =
            new BufferedReader(new InputStreamReader(contents));

        Date s3LastModifiedDate =
            s3object.getObjectMetadata().getLastModified();

        List<?> normaliseList = null;
        try {
            if (fileName.contains("ATG")) {
                normaliseList = normaliseATG(reader, s3LastModifiedDate);
            } else if (fileName.contains("Sale")) {
                normaliseList = normaliseTXN(reader, s3LastModifiedDate);

            }
        } catch (IOException e) {
            context.getLogger().log("Error: " + e);
        }
        publishToSNS(normaliseList);
        return null;
    }

    private void publishToSNS(List normaliseList) {

        String msg = new Gson().toJson(normaliseList);

        AmazonSNSClient snsClient = new AmazonSNSClient();
        snsClient.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));

        PublishRequest publishRequest = new PublishRequest(TOPIC, msg);
        snsClient.publish(publishRequest);

    }

    /**
     * Sale normalizer
     * 
     * @param reader
     * @param context
     * @return
     * @throws IOException
     */
    private List<NormaliseTXNRaw> normaliseTXN(BufferedReader reader,
        Date s3LastModifiedDate) throws IOException {

        List<NormaliseTXNRaw> normaliseTXNRaws =
            new ArrayList<NormaliseTXNRaw>();
        String line;
        while ((line = reader.readLine()) != null) {
          //  String[] lines = line.split(" SiteCode");
         //   for (int i = 0; i < lines.length; i++) {
                List<String> valueList = new ArrayList<String>();
                Arrays.asList(line.split(VALUE_SEPERATOR))
                    .forEach(record -> valueList.add(record
                        .substring(record.indexOf(KEYVALUE_SEPERATOR) + 1)));
                normaliseTXNRaws.add(normaliseTxnRaw(
                    valueList.toArray(new String[0]), s3LastModifiedDate));
          //  }
        }
        return normaliseTXNRaws;
    }

    /**
     * ATG Normaliser
     * 
     * @param reader
     * @param context
     * @return
     * @throws IOException
     */
    private List<NormaliseATGRaw> normaliseATG(BufferedReader reader,
        Date s3LastModifiedDate) throws IOException {

        List<NormaliseATGRaw> normaliseATGRaws =
            new ArrayList<NormaliseATGRaw>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (!StringUtils.isBlank(line)) {
             
             //   String[] lines = line.split(" SiteCode");
               // for (int i = 0; i < lines.length; i++) {
                    List<String> valueList = new ArrayList<String>();
                    Arrays.asList(line.split(VALUE_SEPERATOR))
                        .forEach(record -> valueList.add(record.substring(
                            record.indexOf(KEYVALUE_SEPERATOR) + 1)));
                    normaliseATGRaws.add(normaliseATGRaw(
                        valueList.toArray(new String[0]), s3LastModifiedDate));
              //  }
            }
        }

        return normaliseATGRaws;
    }

    private NormaliseATGRaw normaliseATGRaw(String[] row,
        Date s3LastModifiedDate) {

        return new NormaliseATGRaw(getColumnValue(row, 0),
            getColumnValue(row, 9), getColumnValue(row, -1),
            getColumnValue(row, 1), getColumnValue(row, 11),
            getColumnValue(row, 5), getColumnValue(row, 4),
            getColumnValue(row, 3), getColumnValue(row, 5),
            getColumnValue(row, 7), getColumnValue(row, -1),
            getColumnValue(row, 8), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), s3LastModifiedDate.toString());

    }

    private String getColumnValue(String[] row, Integer index) {
        String columnValue = "N/A";
        if (isValidIndex(index, row.length)) {
            columnValue = row[index];
        }
        return columnValue;
    }

    private boolean isValidIndex(Integer index, Integer arraySize) {
        boolean isValid = true;
        if (index == -1 || index > arraySize - 1) {
            isValid = false;
        }
        return isValid;
    }

    private NormaliseTXNRaw normaliseTxnRaw(String[] row,
        Date s3LastModifiedDate) {

        return new NormaliseTXNRaw(getColumnValue(row, 0),
            getColumnValue(row, 6), getColumnValue(row, 3),
            getColumnValue(row, 4), getColumnValue(row, 1),
            getColumnValue(row, 2), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, 5),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), getColumnValue(row, -1),
            getColumnValue(row, -1), s3LastModifiedDate.toString()

        );

    }
}
