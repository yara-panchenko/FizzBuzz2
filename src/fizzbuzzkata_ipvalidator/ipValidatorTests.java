package fizzbuzzkata_ipvalidator;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ipValidatorTests {
	IpValidator validator = new IpValidator();
	@Before public void setup() {
		assertFalse(validator.ValidateIpv4Address(""));
		int[] expected = {};
		assertArrayEquals(expected,validator.getNumbers(""));
	}
	@Test
	void ShouldReturnFalse_GivenEmptyStringParameter() {
		assertFalse(validator.ValidateIpv4Address(""));
	}	
	
	@Test
	void ShouldBe_False_GivenStringWithOutThreeDots() {
		IpValidator validator = new IpValidator();
		assertFalse(validator.ValidateIpv4Address(".."));
		assertFalse(validator.ValidateIpv4Address("...."));
	}
	
	@Test
	void ShouldReturnFourNumbersGivenStringWithThreeDots() {
		int[] expected = {1,2,3,4};
		assertArrayEquals(expected,validator.getNumbers("1.2.3.4"));
	}
	
	@Test
	void ShouldBe_False_GivenStringWithThreeNumbersAndDots() {
		assertFalse(validator.ValidateIpv4Address("1.2.3."));
	}
	
	@Test
	void ShouldBe_False_GivenStringWithFourNumbersNotInRange0_255(){
		assertFalse(validator.ValidateIpv4Address("1.2.3.257"));
		assertFalse(validator.ValidateIpv4Address("1.2.300.4"));
		assertFalse(validator.ValidateIpv4Address("1.256.3.4"));
		assertFalse(validator.ValidateIpv4Address("312.2.3.4"));
	}
	
	@Test
	void ShouldBe_False_GivenIPstartingWithZero() {
		assertFalse(validator.ValidateIpv4Address("0.2.3.4"));
	}
	
	@Test
	void ShouldBe_False_GivenIPendingWithZero() {
		assertFalse(validator.ValidateIpv4Address("1.2.3.0"));
	}
	
	@Test
	void ShouldBe_False_GivenIPstartingWith255() {
		assertFalse(validator.ValidateIpv4Address("255.2.3.4"));
	}
	
	@Test
	void ShouldBe_False_GivenIPendingWith255() {
		assertFalse(validator.ValidateIpv4Address("1.2.3.255"));
	}
	
}