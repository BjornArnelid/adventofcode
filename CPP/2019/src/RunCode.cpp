/*
 * RunTests.cpp
 *
 *  Created on: Sep 24, 2021
 *      Author: bjorn
 */

#include <filesystem>
#include <fstream>
#include <iostream>
#include <vector>

#include "Day1.cpp"

using namespace std;

const char *ADVENTOFCODEPATH_2019 = "ADVENTOFCODEPATH_2019";


vector<string> read_file(string path) {
	vector<string> file_content;

	string line;
	ifstream file(path.c_str());
	if (file.is_open()){
		while(getline(file, line)) {
			file_content.push_back(line);
		}
		file.close();
	}
	return file_content;
}

void run_day1(string path) {
	vector<string> input = read_file(path + "day1.data");
	cout << "Answer to part one is " << calculate_fuel(input) << endl;
	cout << "Answer to part two is " << calculate_with_extra(input) << endl;
}

int main (int argc, char* argv[]) {
	const char* data_path = getenv(ADVENTOFCODEPATH_2019);
	if (data_path == 0) {
		cout << "Please set environment variable "
				<< ADVENTOFCODEPATH_2019
				<< endl;
		exit(-1);
	}

	run_day1(string(data_path) + "/data/");
}
