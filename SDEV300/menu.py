""" This is the Voter Information Module

This module will take input from the user
and put that input into a dict.
It will then print the formatted output
to the stdout
Created by Joshua Coe
SDEV300

"""

import random
import platform
from os import system
import sys

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
    leaving a long string of incorrect answers

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
    print_head()
    print("passing the word")

    check_return("results")

def check_return(message):
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
        print('3. Days til 4 July 2025')
        print('4. Leg of a Triangle')
        print('5. Volume of a Cylinder')
        print('\n')

        choice = input('Make a choice from the menu above-----> ')
        check_quit(choice)


        if choice == '1':
            password()
            choosing = False
        elif choice == '2':
            print("percentage")
        elif choice == '3':
            print("days to 4j")
        elif choice == '4':
            print("Triangle")
        elif choice == '5':
            print("Cylinder")
        else:
            print("XX-->You made an invalid choice<--XX")
            input("XX-->  Press Enter to continue <--XX")




print_head()
menu_screen()