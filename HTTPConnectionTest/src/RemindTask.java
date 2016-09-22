import java.util.TimerTask;

import org.apache.log4j.Logger;

public class RemindTask extends TimerTask {
	static Logger logger = Logger.getLogger(RemindTask.class);
	@Override
	public void run() {
		int noOfTimes = 5;
		System.out.println("Print Me");
		int executedTimes = 1;
		while (executedTimes <= noOfTimes){
		try {
			String request = "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetAllVDCs&opData={}";
			logger.info("userAPIGetAllVDCs API Request "+request);
			String response = APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", request);
			logger.info("userAPIGetAllVDCs API Response "+response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			//APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetAllVMs&opData={}");
			String request = "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetAllVMs&opData={}";
			logger.info("userAPIGetAllVMs API Request "+request);
			String response = APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", request);
			logger.info("userAPIGetAllVMs API Response "+response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			//APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetAllVMs&opData={}");
			String request = "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetVMSummary&opData={param0:306}";
			logger.info("userAPIGetVMSummary API Request "+request);
			String response = APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", request);
			logger.info("userAPIGetVMSummary API Response "+response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		executedTimes++;
		}

	}

}
