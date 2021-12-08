package fizzbuzzkata_ipvalidator;
import java.util.Arrays;

public class IpValidator {

	public Boolean ValidateIpv4Address(String ipString) {
		if(hasThreeDots(ipString) && 
				hasFourNumbers(ipString) &&
				numbersInRange(ipString) &&
				firstNumberInRange1_254(ipString) &&
				lastNumberInRange1_254(ipString)) {
			return true;
		}
		return false;
	}
	private boolean lastNumberInRange1_254(String ipString) {
		return getNumbers(ipString)[3]>0 && getNumbers(ipString)[3]<255;
	}
	private boolean firstNumberInRange1_254(String ipString) {
		return getNumbers(ipString)[0]>0 && getNumbers(ipString)[0]<255;
	}
	private boolean numbersInRange(String ipString) {
		return Arrays.stream(getNumbers(ipString)).allMatch(nr->nr>=0&&nr<=255);
	}
	private boolean hasFourNumbers(String ipString) {
		return getNumbers(ipString).length == 4;
	}
	private boolean hasThreeDots(String ipString) {
		return ipString.chars().filter(c->c=='.').count()==3;
	}
	public int[] getNumbers(String string) {
		return Arrays.stream( string.split("\\.")).mapToInt(Integer::parseInt).toArray();
	}
}
