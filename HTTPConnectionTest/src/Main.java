import java.util.Timer;

import org.apache.log4j.Logger;


public class Main {
	static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args) throws Exception {
		Timer t = new Timer();
		t.schedule(new RemindTask(), 0, 100000);
		
		///APIHTTPConnection automtion = new APIHTTPConnection();
		//APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetAllVDCs&opData={}");
		//APIHTTPConnection.sendGet("E877ECC05669426E8246FE53F16A2639", "http://172.29.110.238/app/api/rest?formatType=json&opName=userAPIGetAllVMs&opData={}");

	}

}
