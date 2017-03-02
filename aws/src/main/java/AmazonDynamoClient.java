import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

public class AmazonDynamoClient {

    private void runATG() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "RathaTestATG";
        Table table = dynamoDB.getTable(tableName);
    }

    private void runCorrectedATG() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "RathaTestCorrectedATG";
        Table table = dynamoDB.getTable(tableName);
    }

    private void runSale() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "RathaTestSale";
        Table table = dynamoDB.getTable(tableName);
    }

    private void runFlowRate() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient()
            .withEndpoint("dynamodb.ap-southeast-2.amazonaws.com");

        client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "RathaTestFlowRate";
        Table table = dynamoDB.getTable(tableName);
    }

}
