import re


class LuggageRules(object):
    def __init__(self, rule_string):
        self.rules = {}
        for line in rule_string.split('\n'):
            container, content_string = line.split(' bags contain ')
            contents = []
            if content_string != 'no other bags.':
                for content_part in content_string.split(','):
                    number = re.findall(r'\d+', content_part)[0]
                    bag_type = re.findall(r'(\D+\s\D+)bag', content_part)[0]
                    contents.append(ContentRule(int(number), bag_type.strip()))
            self.rules[container] = contents

    def get_top_containers(self, leaf_color):
        allowed_bags = set()
        for bag_color, content_rules in self.rules.items():
            for rule in content_rules:
                if leaf_color == rule.bag_type:
                    allowed_bags.add(bag_color)
                    for parent_color in self.get_top_containers(bag_color):
                        allowed_bags.add(parent_color)
        return allowed_bags

    def count_required_bags(self, bag_color):
        bags_required = 0
        for rule in self.rules[bag_color]:
            bags_required += (1 + self.count_required_bags(rule.bag_type)) * rule.number_of_bags
        return bags_required


class ContentRule(object):
    bag_type = None
    number_of_bags = None

    def __init__(self, no_bags, bag_type):
        self.number_of_bags = no_bags
        self.bag_type = bag_type


if __name__ == '__main__':
    with open('day7.data') as data:
        rules = LuggageRules(data.read().strip())
        print(len(rules.get_top_containers('shiny gold')))
        print(rules.count_required_bags('shiny gold'))
