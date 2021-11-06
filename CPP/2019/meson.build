project('adventofcode_2019', 'cpp')

src = include_directories('src')

executable('adventofcode', 'src/RunCode.cpp', include_directories : src)

gtest_dep = dependency('gtest_main', required : false)
tests = executable('testprog', 'test/Day1_test.cpp', dependencies : gtest_dep, include_directories : src)
test('gtest test', tests)