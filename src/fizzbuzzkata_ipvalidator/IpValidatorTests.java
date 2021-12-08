package fizzbuzzkata_ipvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ipValidatorTests {

	@Test
	void ShouldReturnFalse_GivenEmptyStringParameter() {
		IpValidator validator = new IpValidator();
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
		IpValidator validator = new IpValidator();
		int[] expected = {1,2,3,4};
		assertArrayEquals(expected,validator.getNumbers("1.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenStringWithThreeNumbersAndDots() {
		IpValidator validator = new IpValidator();
		assertFalse(validator.ValidateIpv4Address("1.2.3."));
	}
	@Test
	void ShouldBe_False_GivenStringWithFourNumbersNotInRange0_255(){
		IpValidator validator = new IpValidator();
		assertFalse(validator.ValidateIpv4Address("1.2.3.257"));
		assertFalse(validator.ValidateIpv4Address("1.2.300.4"));
		assertFalse(validator.ValidateIpv4Address("1.256.3.4"));
		assertFalse(validator.ValidateIpv4Address("312.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenIPstartingWithZero() {
		IpValidator validator= new IpValidator();
		assertFalse(validator.ValidateIpv4Address("0.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenIPendingWithZero() {
		IpValidator validator = new IpValidator();
		assertFalse(validator.ValidateIpv4Address("1.2.3.0"));
	}
	@Test
	void ShouldBe_False_GivenIPstartingWith255() {
		IpValidator validator= new IpValidator();
		assertFalse(validator.ValidateIpv4Address("255.2.3.4"));
	}

	@Test
	void ShouldBe_False_GivenIPendingWith255() {
		IpValidator validator = new IpValidator();
		assertFalse(validator.ValidateIpv4Address("1.2.3.255"));
	}

}
