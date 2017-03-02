import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

/**
 * Subscribe to a given topic and process the files and store to Dynamo DB
 * 
 *
 * @version $Rev$ $Date$
 */

public class SNSToLambdaHandler implements RequestHandler<SNSEvent, Object> {

    private static final BigDecimal MM_TO_METERS = new BigDecimal("0.001");

    @Override
    public Object handleRequest(SNSEvent request, Context context) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss")
            .format(Calendar.getInstance().getTime());
        context.getLogger()
            .log("SNS TO LAMBDA INVOCATION STARTED---: " + timeStamp);

        String message = request.getRecords().get(0).getSNS().getMessage();

        context.getLogger().log("Message-------------" + message);

        if (message.contains("trasactionStartDate")) {
            ArrayList<NormaliseTXNRaw> list = new Gson().fromJson(message,
                new TypeToken<List<NormaliseTXNRaw>>() {
                }.getType());
            storeTXNDynamo(list, context);
            storeFlowRateDynamo(list, context);
        } else {
            ArrayList<NormaliseATGRaw> list = new Gson().fromJson(message,
                new TypeToken<List<NormaliseATGRaw>>() {
                }.getType());
            storeATGDynamo(list, context);
            storeCorrectedATGDynamo(list, context);

        }
        return null;

    }

    private void storeATGDynamo(ArrayList<NormaliseATGRaw> list,
        Context context) {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "RathaTestATG";
        Table table = dynamoDB.getTable(tableName);

        DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // LocalDateTime now = LocalDateTime.now();

        for (NormaliseATGRaw raw : list) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String now = dateFormat.format(date);
            String format = "yyyy/MM/dd HH:mm:ss";
            SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date fromDate = null;
            Date toDate = null;
            try {
                fromDate = simpleDateFormat.parse(raw.getS3Timestamp());
                toDate = sdf.parse(now);
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            long diff = toDate.getTime() - fromDate.getTime();
            double diffMinutes = new Long(diff).doubleValue() / (60 * 1000);

            final Map<String, Object> infoMap = new HashMap<String, Object>();
            infoMap.put(NormalisedATGEnum.SITE_CODE.getName(),
                raw.getSiteCode());
            infoMap.put(NormalisedATGEnum.TIMESTAMP.getName(),
                raw.getTimestamp());
            infoMap.put(NormalisedATGEnum.TEMPERATURE.getName(),
                raw.getTemperature());
            infoMap.put(NormalisedATGEnum.TANK_CODE.getName(),
                raw.getTankCode());
            infoMap.put(NormalisedATGEnum.TANK_ULLAGE.getName(),
                raw.getTankUllage());
            infoMap.put(NormalisedATGEnum.WATER_LEVEL.getName(),
                raw.getWaterLevel());
            infoMap.put(NormalisedATGEnum.ATG_LEVEL.getName(),
                raw.getAtgLevelMM());
            infoMap.put(NormalisedATGEnum.ATG_VOLUME.getName(),
                raw.getAtgVolumeL());
            infoMap.put(NormalisedATGEnum.S3_TIMESTAMP.getName(),
                raw.getS3Timestamp());
            // infoMap.put("DynamoDB Timestamp", dtf.format(now));
            infoMap.put("DynamoDB Timestamp", now);
            infoMap.put("TimeGap betweenS3 and Dynamo in minutes", diffMinutes);

            String primaryKey = raw.getSiteCode() + "_" + raw.getTankCode()
                + "_" + raw.getTimestamp();
            try {
                table.putItem(new Item().withPrimaryKey("Id", primaryKey)
                    .withMap("content", infoMap).withKeyComponent("TimeGap-betweenS3-and-Dynamo", diffMinutes));
                context.getLogger()
                    .log("Stroed to DB , ATG Primary Key-----: " + primaryKey);
            } catch (Exception e) {
                context.getLogger().log("ERROR IN STORING ATG: " + e);
            }

        }
    }

    private void storeTXNDynamo(ArrayList<NormaliseTXNRaw> list,
        Context context) {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "RathaTestSale";
        Table table = dynamoDB.getTable(tableName);

        DateTimeFormatter dtf =
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        for (NormaliseTXNRaw raw : list) {
            final Map<String, Object> infoMap = new HashMap<String, Object>();
            infoMap.put(NormalisedTXNEnum.SITE_CODE.getName(),
                raw.getSiteCode());
            infoMap.put(NormalisedTXNEnum.TANK_CODE.getName(),
                raw.getTankCode());
            infoMap.put(NormalisedTXNEnum.HOSE_CODE.getName(),
                raw.getHoseCode());
            infoMap.put(NormalisedTXNEnum.DISPENSER_CODE.getName(),
                raw.getDispenserCode());
            infoMap.put(NormalisedTXNEnum.TRANSACTION_START_DATE.getName(),
                raw.getTrasactionStartDate());
            infoMap.put(NormalisedTXNEnum.TRANSACTION_END_DATE.getName(),
                raw.getTrasactionEndDate());
            infoMap.put(NormalisedTXNEnum.VOLUME.getName(), raw.getVolume());
            infoMap.put(NormalisedTXNEnum.TRANSACTION_ID.getName(),
                raw.getTransactionId());

            infoMap.put(NormalisedTXNEnum.S3_TIMESTAMP.getName(),
                raw.getS3Timestamp());

            infoMap.put("DynamoDB Timestamp", dtf.format(now));

            String primaryKey =
                raw.getSiteCode() + "_" + raw.getTransactionId()+"_"+raw.getTrasactionStartDate();

            try {

                table.putItem(new Item().withPrimaryKey("Id", primaryKey)
                    .withMap("info", infoMap));
                context.getLogger()
                    .log("Stroed to DB , Sale Primary Key-----: " + primaryKey);
            } catch (Exception e) {
                context.getLogger().log("ERROR IN STORING SALE: " + e);
            }

        }

    }

    private void storeCorrectedATGDynamo(ArrayList<NormaliseATGRaw> list,
        Context context) {

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal c = new BigDecimal("0.3");
        BigDecimal d = new BigDecimal("0.4");
        BigDecimal e = new BigDecimal("0.6");
        BigDecimal f = new BigDecimal("0.7");
        BigDecimal g = new BigDecimal("0.8");

        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "RathaTestCorrectedATG";
        Table table = dynamoDB.getTable(tableName);

        for (NormaliseATGRaw raw : list) {
            final Map<String, Object> infoMap = new HashMap<String, Object>();
            String ATGHeight_mm = raw.getAtgLevelMM();

            BigDecimal ATGHeight_m =
                new BigDecimal(ATGHeight_mm).multiply(MM_TO_METERS);
            BigDecimal power_2 = ATGHeight_m.pow(2);
            BigDecimal power_3 = ATGHeight_m.pow(3);

            BigDecimal power_4 = ATGHeight_m.pow(4);
            BigDecimal power_5 = ATGHeight_m.pow(5);
            BigDecimal power_6 = ATGHeight_m.pow(6);

            BigDecimal volume_b = a.add(b.multiply(ATGHeight_m));
            BigDecimal volume_c = c.multiply(power_2);
            BigDecimal volume_d = d.multiply(power_3);
            BigDecimal volume_e = e.multiply(power_4);
            BigDecimal volume_f = f.multiply(power_5);
            BigDecimal volume_g = g.multiply(power_6);

            BigDecimal correctedVolume = volume_b.add(volume_c).add(volume_d)
                .add(volume_e).add(volume_f).add(volume_g);

            infoMap.put(NormalisedATGEnum.SITE_CODE.getName(),
                raw.getSiteCode());
            infoMap.put(NormalisedATGEnum.TIMESTAMP.getName(),
                raw.getTimestamp());
            infoMap.put(NormalisedATGEnum.TEMPERATURE.getName(),
                raw.getTemperature());
            infoMap.put(NormalisedATGEnum.TANK_CODE.getName(),
                raw.getTankCode());
            infoMap.put("CorrectedVolume", correctedVolume.toString());

            String primaryKey = raw.getSiteCode() + "_" + raw.getTankCode()
                + "_" + raw.getTimestamp();

            table.putItem(new Item().withPrimaryKey("Id", primaryKey)
                .withMap("content", infoMap));

            context.getLogger().log(
                "Stroed to DB , Corrected ATG Primary Key-----: " + primaryKey);

        }

    }

    private void storeFlowRateDynamo(ArrayList<NormaliseTXNRaw> list,
        Context context) {

        ZonedDateTime d1 = null;
        ZonedDateTime d2 = null;
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "RathaTestFlowRate";

        Table table = dynamoDB.getTable(tableName);

        for (NormaliseTXNRaw raw : list) {
            final Map<String, Object> infoMap = new HashMap<String, Object>();

            d1 = ZonedDateTime.parse(raw.getTrasactionEndDate().trim());
            d2 = ZonedDateTime.parse(raw.getTrasactionStartDate().trim());

            long diff =
                d1.toInstant().toEpochMilli() - d2.toInstant().toEpochMilli();

            double diffMinutes = new Long(diff).doubleValue() / (60 * 1000);

            context.getLogger().log("Flowrate time diff in ms -----: " + diff);
            context.getLogger()
                .log("Flowrate time diff in minutes -----: " + diffMinutes);

            double salevoulme = Double.parseDouble(raw.getVolume().trim());

            context.getLogger()
                .log("Flowrate sale volume -----: " + salevoulme);

            double flowRate = salevoulme / diffMinutes;

            infoMap.put(NormalisedTXNEnum.SITE_CODE.getName(),
                raw.getSiteCode());
            infoMap.put(NormalisedTXNEnum.TANK_CODE.getName(),
                raw.getTankCode());
            infoMap.put(NormalisedTXNEnum.HOSE_CODE.getName(),
                raw.getHoseCode());
            infoMap.put(NormalisedTXNEnum.DISPENSER_CODE.getName(),
                raw.getDispenserCode());
            infoMap.put("FlowRate ", String.valueOf(flowRate));

            String primaryKey =
                raw.getSiteCode() + "_" + raw.getTransactionId()+"_"+raw.getTrasactionStartDate();

            try {
                table.putItem(new Item().withPrimaryKey("Id", primaryKey)
                    .withMap("info", infoMap));
                context.getLogger().log(
                    "Stroed to DB , FLOWRATE Primary Key-----: " + primaryKey);
            } catch (Exception e) {
                context.getLogger().log("Error in storing FLOWRATE-----: " + e);
            }
        }
    }

}
