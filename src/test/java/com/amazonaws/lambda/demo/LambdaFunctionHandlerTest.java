package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

    private DynamodbEvent event;

    @Before
    public void createInput() throws IOException {
        // TODO: set up your sample input object here.
        event = TestUtils.parse("/dynamodb-update-event.json", DynamodbEvent.class);
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("LambdaDynamoDBJunit");

        return ctx;
    }

    @SuppressWarnings("static-access")
	@Test
    public void testLambdaFunctionHandler() {
        LambdaFunctionHandler handler = new LambdaFunctionHandler();
        Context ctx = createContext();
for(int i=0;i<100;i++){
	Thread thread=new Thread();
	thread.start();
        Integer output = handler.handleRequest(event, ctx);
        
        try {
			thread.sleep(5000);
			System.out.println("call number "+i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // TODO: validate output here if needed.
        Assert.assertEquals(3, output.intValue());
}
    }
}
