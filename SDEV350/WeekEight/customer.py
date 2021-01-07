import random, sys

first_names = []
last_names = []
domains = []
normal_domains = []
nicknames = []
area_codes = {}
code_list = []
with open('firstnames.txt', 'r') as infile:
    first_names = infile.readlines()

with open('lastnames.txt', 'r') as infile:
    last_names = infile.readlines()

with open('nicknames.txt', 'r') as infile:
    nicknames = infile.readlines()

with open('domains.txt', 'r') as infile:
    domains = infile.readlines()

with open('normaldomains.txt', 'r') as infile:
    normal_domains = infile.readlines()

with open('areacodes.txt') as infile:  
    lines = infile.readlines()
    for i in lines:
        splitup = i.split(' ')
        code = splitup[0]
        state = splitup[2]
        area_codes[code] = state
        code_list.append(code)

def make_phone():
    code = random.choice(code_list)
    prefix = random.randint(100,999)
    suffix = random.randint(1000,9999)
    phone = f'{code}{prefix}{suffix}'
    return(int(phone))
    
def make_email(type, firstname='', lastname=''):
    email =''
    first = ''
    domain = ''
    if type == 'name':
        seperators = ['.', '-', '']
        seperator = random.choice(seperators)
        if random.randint(1,100)>15:
            random_ender = str(random.randint(1,10000))
        else:
            random_ender = ''
        first_name = firstname
        last_name = lastname
        first = f'{first_name.rstrip()}{seperator.rstrip()}{last_name.rstrip()}{random_ender.rstrip()}'
    
    elif type == 'nickname':
        first = random.choice(nicknames).rstrip()
        if random.randint(1,100)>15:
            random_ender = str(random.randint(1,10000))
        else:
            random_ender = ''
        first += random_ender
    
    if random.randint(1,100)<25:
        domain = random.choice(domains).rstrip()
    else:
        domain = random.choice(normal_domains).rstrip()
    
    third = [first, domain]
    email = '@'.join(third)
    return(email)



for i in range(0,int(sys.argv[1])):
    firstname = random.choice(first_names).rstrip()
    lastname = random.choice(last_names).rstrip()
    types = ['name', 'nickname']
    email_type = random.choice(types)
    email = make_email(email_type, firstname, lastname)
    phonenum = make_phone()
    print(f'{firstname} {lastname} {email} {phonenum}')