/*
 * Day1_test.cpp
 *
 *  Created on: Mar 9, 2021
 *      Author: bjorn
 */

#include "Day1.cpp"

#include "gtest/gtest.h"


TEST(Day1_test, Test_TwelweEqualsTwo) {
	int answer = calculate_fuel(12);
	ASSERT_EQ(answer, 2);
}

TEST(Day1_test, Test_FourteenEqualsTwo) {
	int answer = calculate_fuel(14);
	ASSERT_EQ(answer, 2);
}

TEST(Day1_test, Test_1969Equals654) {
	int answer = calculate_fuel(1969);
	ASSERT_EQ(answer, 654);
}

TEST(Day1_test, Test_100756Equals33583) {
	int answer = calculate_fuel(100756);
	ASSERT_EQ(answer, 33583);
}

TEST(Day1_test, TestFourteenWithExtraEqualsTwo) {
	int fuel = calculate_fuel(14);
	fuel += calculate_extra_fuel(fuel);
	ASSERT_EQ(fuel, 2);
}

TEST(Day1_test, Test1969WithExtraEquals654) {
	int fuel = calculate_fuel(1969);
	fuel += calculate_extra_fuel(fuel);
	ASSERT_EQ(fuel, 966);
}

TEST(Day1_test, Test100756WithExtraEquals50346) {
	int fuel = calculate_fuel(100756);
	fuel += calculate_extra_fuel(fuel);
	ASSERT_EQ(fuel, 50346);
}

int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}
