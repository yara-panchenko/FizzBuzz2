package fizzbuzzkata_ipvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ipValidatorTests {

	@Test
	void ShouldReturnFalse_GivenEmptyStringParameter() {
		ipValidator validator = new ipValidator();
		assertFalse(validator.ValidateIpv4Address(""));
	}

}
