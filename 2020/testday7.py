import unittest

from day7 import LuggageRules

test_rules = '''light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags.'''

count_test = '''shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.'''

rules = LuggageRules(test_rules)


class Day7Test(unittest.TestCase):
    def test_bright_white_contains_shiny_gold(self):
        self.assertIn('bright white', rules.get_top_containers('shiny gold'))

    def test_muted_yellow_contains_shiny_gold(self):
        self.assertIn('muted yellow', rules.get_top_containers('shiny gold'))

    def test_dark_orange_contains_shiny_gold_indirectly(self):
        self.assertIn('dark orange', rules.get_top_containers('shiny gold'))

    def test_count_allowed_bags(self):
        self.assertEqual(4, len(rules.get_top_containers('shiny gold')))

    def test_required_bags_faded_blue(self):
        self.assertEqual(0, rules.count_required_bags('faded blue'))

    def test_required_bags_vibrant_plum(self):
        self.assertEqual(11, rules.count_required_bags('vibrant plum'))

    def test_required_bags_shiny_gold(self):
        self.assertEqual(32, rules.count_required_bags('shiny gold'))

    def test_required_bags2(self):
        count_rules = LuggageRules(count_test)
        self.assertEqual(126, count_rules.count_required_bags('shiny gold'))


if __name__ == '__main__':
    unittest.main()
