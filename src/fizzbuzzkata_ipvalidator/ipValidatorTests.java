package fizzbuzzkata_ipvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ipValidatorTests {

	@Test
	void ShouldReturnFalse_GivenEmptyStringParameter() {
		ipValidator validator = new ipValidator();
		assertFalse(validator.ValidateIpv4Address(""));
	}
	@Test
	void ShouldBe_False_GivenStringWithOutThreeDots() {
		ipValidator validator = new ipValidator();
		assertFalse(validator.ValidateIpv4Address(".."));
		assertFalse(validator.ValidateIpv4Address("...."));
	}
	@Test
	void ShouldReturnFourNumbersGivenStringWithThreeDots() {
		ipValidator validator = new ipValidator();
		int[] expected = {1,2,3,4};
		assertArrayEquals(expected,validator.getNumbers("1.2.3.4"));
	}
	@Test
	void ShouldBe_False_GivenStringWithThreeNumbersAndDots() {
		ipValidator validator = new ipValidator();
		assertFalse(validator.ValidateIpv4Address("1.2.3."));
	}

}
