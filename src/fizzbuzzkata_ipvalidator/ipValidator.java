package fizzbuzzkata_ipvalidator;

public class ipValidator {

	public Boolean ValidateIpv4Address(String ipString) {
		if(hasThreeDots(ipString)) {
			return true;
		}
		return false;
	}

	private boolean hasThreeDots(String ipString) {
		return ipString.chars().filter(c->c=='.').count()==3;
	}
}
