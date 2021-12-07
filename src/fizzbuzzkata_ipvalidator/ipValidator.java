package fizzbuzzkata_ipvalidator;
import java.util.Arrays;

public class ipValidator {

	public Boolean ValidateIpv4Address(String ipString) {
		if(hasThreeDots(ipString) && 
				hasFourNumbers(ipString) &&
				numbersInRange(ipString)) {
			return true;
		}
		return false;
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
