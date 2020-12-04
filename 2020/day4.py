def passport_valid(passport, check_fields=False):
    passport_map = dict(x.split(':') for x in passport.split())
    if not all(x in passport_map for x in ['byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid']):
        return False
    elif not check_fields:
        return True
    return verify_fields(passport_map)


def verify_fields(passport_map):
    try:
        if 1920 > int(passport_map['byr']) or int(passport_map['byr']) > 2002:
            return False
        if 2010 > int(passport_map['iyr']) or int(passport_map['iyr']) > 2020:
            return False
        if 2020 > int(passport_map['eyr']) or int(passport_map['eyr']) > 2030:
            return False
        if passport_map['hgt'].endswith('cm'):
            if 150 > int(passport_map['hgt'][:-2]) or int(passport_map['hgt'][:-2]) > 193:
                return False
        elif passport_map['hgt'].endswith('in'):
            if 59 > int(passport_map['hgt'][:-2]) or int(passport_map['hgt'][:-2]) > 76:
                return False
        else:
            return False
        if passport_map['hcl'][0] == '#' and len(passport_map['hcl']) == 7:
            int('0X' + passport_map['hcl'][1:], 16)
        else:
            return False
        if passport_map['ecl'] not in ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']:
            return False
        if len(passport_map['pid']) == 9:
            int(passport_map['pid'])
        else:
            return False
        return True
    except ValueError:
        return False


def count_valid_passports(passports, check_fields=False):
    valid = 0
    for passport in passports.split('\n\n'):
        if passport_valid(passport, check_fields):
            valid += 1
    return valid


if __name__ == '__main__':
    with open('day4.data') as data:
        print(count_valid_passports(data.read(), True))

