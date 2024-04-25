package org.example.deneme123;
//GÖKBERK EFE ÇETİNKAYA
//B211202373
//SOFTWARE VERIFICATION AND VALIDATION - JUNIT5HOMEWORK
// Github RepositoryAdress: https://github.com/GokberkEfe/JunitTestHomework
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class Deneme123ApplicationTests {

	/*@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void testDivision1() {
		assertEquals(5, Calculator.divide(10, 2));
	}

	@Test
	void testDivision2() {
		assertEquals(2.5, Calculator.divide(10, 4));
	}

	@Test
	void testDivision3() {
		assertEquals(5, Calculator.divide(12.5f, 2.5f));
	}

	@Test
	void testDivision4() {
		assertEquals(4, Calculator.divide(10, 2.5f));
	}

	@Test
	void testDivision5() {
		assertEquals(2.5f, Calculator.divide(12.5f, 5));
	}

	@Test
	void testDivision6() {
		Exception exception = assertThrows(
				IllegalArgumentException.class,
				() -> Calculator.divide(12.5f, 0),
				"IllegalArgumentException expectedss."
		);

		// Optional. To check whether the error messages match.
		assertEquals("Illegal Argument Exceptionss.", exception.getMessage());
	}*/

	@ParameterizedTest
	@MethodSource("divisionDataProvider")
	void testDivision(float dividend, float divisor, float expectedResult) {
		if (divisor == 0) {
			assertThrows(IllegalArgumentException.class, () -> {
				// Perform division and expect an IllegalArgumentException
				Calculator.divide(dividend, divisor);
			},"Division by zeross");
		} else {
			// Perform division and check the result
			float result = Calculator.divide(dividend, divisor);
			assertEquals(expectedResult, result);
		}
	}

	static Stream<Arguments> divisionDataProvider() {
		return Stream.of(
				Arguments.of(10, 2, 5),
				Arguments.of(10, 4, 2.5f),
				Arguments.of(12.5f, 2.5f, 5),
				Arguments.of(10, 2.5f, 4),
				Arguments.of(12.5f, 5, 2.5f),
				Arguments.of(12.5f, 0,0) // Expecting 0 when divisor is 0
		);
	}

}
