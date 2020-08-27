""" This is the Voter Information Module

This module will take input from the user
and put that input into a dict.
It will then print the formatted output
to the stdout
Created by Joshua Coe
SDEV300
"""

import platform
from os import system
import sys
import time
import string
import secrets
import datetime

def print_head():
    '''
    prints the head of the program
    with instructions on how to exit
    the program
    '''
    clear_screen()
    print('*********************************************')
    print('** Welcome to the random functions App.    **')
    print('** Make a selection from the menu below    **')
    print('** You can quit at any time by entering -q **')
    print('*********************************************')
    print('---------------------------------------------')

def clear_screen():
    '''
    clears the screen after checking which
    system architecture is used.
    used to clean up input and stop it from
    leaving a long string text

    '''

    systems = platform.system()

    if systems == 'Windows':
        _ = system('cls')
    else:
        _ = system('clear')

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
            'Thank you for using my app. Goodbye!')

def password():
    '''
    Function to user for variables to
    create a password
    '''
    print_head()
    options = {'passLength': 0, 'Uppercase Letters': 'n',\
'Lowercase Letters': 'n', 'Numbers': 'n', 'Special Characters': 'n'}
    try:
        pass_length_get = input("How many characters long do you want your password to be? ")
        check_quit(pass_length_get)
        pass_length_get = int(pass_length_get)
        options.update({'passLength': pass_length_get})
    except ValueError:
        check_return("You must choose an integer for length!")

    print("Choose the characters you would like to include.")
    for setting in options:
        if setting != 'passLength':
            choosing = True
            choice_count = 0
            while choosing:
                answer = input(setting+"(y/n)? ").lower()
                check_quit(answer)
                if answer in ['y', 'n']:
                    choosing = False
                else:
                    if choice_count < 2:
                        print("Enter only Y or N!")
                        choice_count += 1
                    else:
                        check_return("Too many bad selections.")

            options.update({setting: answer})

    password_out = make_password(options)
    check_return("Your Password is: "+password_out)

def make_password(settings):
    '''
    Function to construct a password
    Parameters:
        settings dict containing the choices needed
    Returns:
        password string in the length and specs provided
    '''
    length = settings['passLength']
    constructed_password = ''
    character_set = ''
    if settings['Uppercase Letters'].lower() == 'y':
        character_set += string.ascii_uppercase
    if settings['Lowercase Letters'].lower() == 'y':
        character_set += string.ascii_lowercase
    if settings['Numbers'].lower() == 'y':
        character_set += string.digits
    if settings['Special Characters'].lower() == 'y':
        character_set += string.punctuation
    print(len(character_set))
    if len(character_set) != 0:
        constructed_password = ''.join(secrets.choice(character_set) for i in range(length))
    else:
        check_return("You did not enter any characters to choose from!")

    return constructed_password

def percentage():
    '''
    Function to calculate and format
    a percentage given a numerator and
    denominator
    '''
    numerator = 0
    denominator = 0
    places = 0
    choice_count = 0
    print("Please use only integers with this function")
    while True:
        try:
            numerator = input("Enter the numerator: ")
            check_quit(numerator)
            numerator = int(numerator)
        except ValueError as e:
            if choice_count < 2:
                print("Only integers (Whole Numbers)!")
                choice_count += 1
            else:
                check_return("Too many bad selections.")
        try:
            denominator = input("Enter the denominator: ")
            check_quit(denominator)
            denominator = int(denominator)
        except ValueError as e:
            if choice_count < 2:
                print("Only integers (Whole Numbers)!")
                choice_count += 1
            else:
                check_return("Too many bad selections.")
        try:
            places = input("How many decimal places: ")
            check_quit(places)
            places = int(places)
            break
        except ValueError as e:
            if choice_count < 2:
                print("Only integers (Whole Numbers)!")
                choice_count += 1
            else:
                check_return("Too many bad selections.")
    calculated_percentage = (numerator/denominator)
    formatted = "{:.{places_after}%}".format(calculated_percentage, places_after=places)
    check_return(str(numerator)+"/"+str(denominator)+" = "+str(formatted))


def daysto4july():
    '''
    fucntion to calculate the number of days
    from today until july 4th 2025
    '''
    date_future = datetime.date(2025, 7, 4)
    date_today = datetime.date.today()
    days_between = date_future - date_today
    check_return("There are "+str(days_between.days)+" days between today and 4 July 2025.")

def triangle():
    '''
    Function to calculate the leg of
    triangle using the law of cosines
    '''
    pass

def cylinder():
    '''
    Function to calculate the volume
    of a right cylinder
    '''
    pass

def check_return(message):
    '''
    Function to display the output of the previous function
    and ask the user if they want to return to the menu or
    quit the program.
    '''
    print_head()
    print('\n')
    print(message)
    print('\n')
    print('---------------------------------------------')
    print('\n')

    print("1. Return to menu")
    print("2. Exit the program")
    print('\n')
    choice = input('Make a choice from the menu above-----> ')
    check_quit(choice)

    if choice == '1':
        menu_screen()
    elif choice == '2':
        leave_program("Goodbye! Thanks for using my app.")
    else:
        leave_program("You made an unrecognized choice. Goodbye!")

def menu_screen():
    '''
    function to take the user's choice
    and run that choice through a switch
    to choose which function to run
    '''

    choosing = True

    while choosing:
        print_head()

        print('1. Generate Password')
        print('2. Calulate Percentage')
        print('3. Days until 4 July 2025')
        print('4. Leg of a Triangle')
        print('5. Volume of a Cylinder')
        print('\n')

        choice = input('Make a choice from the menu above-----> ')
        check_quit(choice)


        if choice == '1':
            password()
            choosing = False
        elif choice == '2':
            percentage()
            choosing = False
        elif choice == '3':
            daysto4july()
            choosing = False
        elif choice == '4':
            triangle()
            choosing = False
        elif choice == '5':
            cylinder()
            choosing = False
        else:
            print("XX-->You made an invalid choice<--XX")
            input("XX-->  Press Enter to continue <--XX")




print_head()
menu_screen()
