/*
 * Day1.cpp
 *
 */

#include <iostream>
#include <vector>

using namespace std;
int calculate_fuel(int mass) {
	return mass / 3 - 2;
}

int calculate_extra_fuel(int fuel) {
	int total_extra = 0;
	int extra = calculate_fuel(fuel);
	while (extra > 0) {
		total_extra += extra;
		extra = calculate_fuel(extra);
	}
	return total_extra;
}

int calculate_fuel(vector<string> mass_input) {
	int combined_fuel = 0;
	for (string mass_string : mass_input) {
		int mass = stoi(mass_string);
		combined_fuel += calculate_fuel(mass);
	}
	return combined_fuel;
}

int calculate_with_extra(vector<string> mass_input) {
	int combined_fuel = 0;
	for (string mass_string : mass_input) {
		int mass = stoi(mass_string);
		int fuel = calculate_fuel(mass);
		fuel += calculate_extra_fuel(fuel);
		combined_fuel += fuel;
	}
	return combined_fuel;
}
