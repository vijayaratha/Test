import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class APIGatewayToLambda implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse>{

    @Override
    public ApiGatewayResponse handleRequest(ApiGatewayRequest request,
        Context context) {
        
        String date = request.getHeaders().get("Date");
        String reply = "Hello date is :" + date;
        ApiGatewayResponse response = new ApiGatewayResponse(200, null, reply);
        return response;

    }

}
