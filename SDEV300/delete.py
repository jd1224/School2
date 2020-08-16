""" This is the Voter Information Module

This Module take input and creates a voter object

"""

import sys
import re
import platform
from os import system


def print_head():
    '''
    prints the head of the program
    with instructions on how to exit
    the program
    '''

    print('*********************************************')
    print('** Welcome to the Voter Information App.   **')
    print('** Answer the questions to register.       **')
    print('** You can quit at any time by entering -q **')
    print('*********************************************')
    print('---------------------------------------------')


def leave_program(message):
    '''
    prints the supplied message and
    gracefully exits the program

    parameters:
        message (str): a message strin
    '''

    print(message)
    sys.exit(0)


def check_quit(variable):
    '''
    checks for the quit variable
    calls the leave_program function if found

    parameters:
        variable (str): variable to check
    '''

    if variable == '-q':

        leave_program('You have entered -q to quit. '\
            'No information saved. Program exiting. Goodbye!')


def get_age():
    '''
    Takes user input for age
    checks for age in range 18 to 110

    returns:
        age (int): user input for age

    '''

    choosing = True
    answer_count = 0
    while choosing:
        age = input("What is your age in years? ")
        check_quit(age)
        try:
            age = int(age)
            break
        except ValueError:
            if answer_count < 2:
                print('You must enter a whole number')
                answer_count += 1
            else:
                choosing = False

    if  not isinstance(age, int):
        leave_program('You made too many incorrect selections.  Please try again. Goodbye!')

    if age < 18:
        leave_program('You are not old enough to vote in the United States. Goodbye!')
    elif age > 109:
        leave_program('I think you made a mistake'\
            'you entered your age as ' + str(age)+' Goodbye!')
    else:
        clear_screen()
        print_head()
        return age

def get_citizenship():
    '''
    takes user input for citizenship

    returns:
        citizenship (str) user input for citizenship

    '''
    choosing = True
    answer_count = 0
    while choosing:
        citizen = input('Are you currently a US Citizen? ').lower()
        check_quit(citizen)

        if citizen in ('n', 'no'):
            leave_program('Only US Citizens are allowed to Vote. Goodbye!')
        elif citizen not in ('y', 'yes'):
            if answer_count < 2:
                print('Please enter either "Yes" or "No".')
                answer_count += 1
            else:
                choosing = False
        else:
            clear_screen()
            print_head()
            return 'Yes'
    leave_program('You made too many incorrect selections.  Please try again. Goodbye!')


def get_state():
    '''
    takes user input for state
    abbreviation. check for valid
    us state code

    returns:
        state (str) user entered state code

    '''

    states = ['al', 'ak', 'az', 'ar', 'ca', 'co', 'ct', 'de', 'dc', 'fl', 'ga', 'hi',\
         'id', 'il', 'in', 'ia', 'ks', 'ky', 'la', 'me', 'md', 'ma', 'mi', 'mn', 'ms',\
              'mo', 'mt', 'ne', 'nd', 'nv', 'nh', 'nj', 'nm', 'ny', 'nc', 'oh', 'ok', 'or',\
                   'pa', 'ri', 'sc', 'sd', 'tn', 'tx', 'ut', 'vt', 'va', 'wa', 'wv', 'wi', 'wy']

    choosing = True
    answer_count = 0
    while choosing:
        state = input('Enter the two letter abbreviation of the state you are from: ').lower()

        if state not in states:
            if answer_count < 2:
                print("You must enter a valid US state abbreviation.")
            else:
                choosing = False
        else:
            clear_screen()
            print_head()
            return state

    leave_program('You made too many incorrect selections.  Please try again. Goodbye!')


def get_zipcode():
    '''
    takes user input for zip code
    checks against a regex for a five or
    nine digit code

    returns:
        zipcode (str) user input zipcode

    '''

    valid_zip = re.compile('^[0-9]{5}(?:-[0-9]{4})?$')

    choosing = True
    answer_count = 0
    while choosing:
        zipcode = input('Enter a five or nine digit zipcode: ')
        matching = valid_zip.match(zipcode)

        if not matching:
            if answer_count < 2:
                print("Zipcodes must be either five digits or nine digits with a hyphen.")
                answer_count += 1
            else:
                choosing = False
        else:
            clear_screen()
            print_head()
            return zipcode

    leave_program('You made too many incorrect selections.  Please try again. Goodbye!')

def get_fname():
    '''
    take user input for first name

    returns:
        name (str) user input for first name

    '''

    name = input("Eneter your first Name: ")
    check_quit(name)
    clear_screen()
    print_head()
    return name



def get_lname():
    '''
    takes user input for last name

    returns:
        name (str) user input for last name

    '''

    name = input("Eneter your last Name: ")
    check_quit(name)
    clear_screen()
    print_head()
    return name



def clear_screen():
    '''
    clears the screen after checking which
    system architecture is used.
    used to clean up input and stop it from
    leaving a long string of incorrect answers

    '''

    systems = platform.system()

    if systems == 'Windows':
        _ = system('cls')
    else:
        _ = system('clear')


def print_voter(validated_applicant):
    '''
    format and print the voter information

    parameters:
        applicant (dict) containing the required variables
        lname, fname, age, citizenship, state, zipcode

    '''

    voter = validated_applicant
    print('********Thank you for registering to vote********')
    print('******We received the following information******')
    print('*************************************************')
    print('Name (Last, First): '+voter.get('lname').capitalize()+', \
'+voter.get('fname').capitalize())
    print('Age: '+str(voter.get('age')))
    print('US Citizen: '+voter.get('citizenship'))
    print('Location: '+voter.get('state').upper()+' '+voter.get('zipcode'))
    print('**************************************************')
    print('**Your card should arrive by mail within 2 weeks**')
    print('**************************************************')

#clear the console to present a clean appearance
clear_screen()
#print the greeting with instructions on how to exit
print_head()
#crete an applicant object as a dict
applicant = {}
#use the methods above to fill the dict
applicant['age'] = get_age()
applicant['citizenship'] = get_citizenship()
applicant['state'] = get_state()
applicant['zipcode'] = get_zipcode()
applicant['fname'] = get_fname()
applicant['lname'] = get_lname()
#clear the screen to print the voter registration card
clear_screen()
print_voter(applicant)
