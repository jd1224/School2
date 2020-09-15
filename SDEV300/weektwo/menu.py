"""
This is the random functions app
it will display a menu with the selections
available to the user and complete the tasks
from the project specification.
Created by Joshua Coe
SDEV300
"""

import platform
from os import system
import sys
import string
import secrets
import datetime
import math

def print_head():
    '''
    prints the head of the program
    with instructions on how to exit
    the program
    '''
    clear_screen()
    print('*********************************************')
    print('** Welcome to the random functions App.    **')
    print('** Follow the directions on screen below.  **')
    print('** You can quit at any time by entering -q.**')
    print('*********************************************')
    print('---------------------------------------------')

def clear_screen():
    '''
    clears the screen after checking which
    system architecture is used.
    used to clean up input and stop it from
    leaving a long string of text
    '''
    systems = platform.system()         #determine the type of system
    #set appropriate value for clearing the screen
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
    #clean up with print_head() then print the supplied message
    print_head()
    print(message)
    sys.exit(0)

def check_quit(variable):
    '''
    checks for the quit variable
    calls the leave_program function if found

    parameters:
        variable (str): variable to check
    '''
    # checks for the sentinel string
    if variable == '-q':

        leave_program('You have entered -q to quit.\n'\
            'Thank you for using my app. Goodbye!')

def check_input(type_choice, prompt):
    '''
    helper function to validate input and
    only allow three incorrect answers per
    attempt
    parameters:
        type_choice (type) of variable to return
        prompt (str) prompt to ask the user for input
    returns:
        variable (object) of the type supplied
    '''
    #split out the actual type from the variable
    var_type = str(type_choice).split("'")[1]
    choice_count = 0
    choosing = True
    #supply the prompt and allow three chances to enter the correct type
    while choosing:
        try:
            variable = input(prompt)
            check_quit(variable)
            #typecast to the correct type
            variable = type_choice(variable)
            choosing = False
        except ValueError:
            if choice_count < 2:
                print('Please enter a '+var_type+' !')
                choice_count += 1
            else:
                check_return("Too many bad selections.")
    return variable

def password():
    '''
    Function to prompt user for variables to
    create a password
    '''
    print_head()
    #create a dict for the options I will use
    options = {'passLength': 0, 'Uppercase Letters': 'n',\
'Lowercase Letters': 'n', 'Numbers': 'n', 'Special Characters': 'n'}

    options.update({'passLength':check_input(int, "How\
 many characters long do you want your password to be? ")})

    print("Choose the characters you would like to include.")
    for setting in options:
        if setting != 'passLength':
            choosing = True
            choice_count = 0
            #check for a y or n, allow three tries before returning to main menu
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
            #add the chosen option to the dict
            options.update({setting: answer})
    #pass the options to the password maker, then display the password
    password_out = make_password(options)
    check_return("Your Password is: "+password_out)

def make_password(settings):
    '''
    Function to construct a password
    Parameters:
        settings (dict) containing the choices needed
    Returns:
        password (str) in the length and specs provided
    '''
    #series of if statements to check set the character set
    length = settings['passLength']
    constructed_password = ''
    character_set = ''
    if settings['Uppercase Letters'] == 'y':
        character_set += string.ascii_uppercase
    if settings['Lowercase Letters'] == 'y':
        character_set += string.ascii_lowercase
    if settings['Numbers'] == 'y':
        character_set += string.digits
    if settings['Special Characters'] == 'y':
        character_set += string.punctuation
    if len(character_set) != 0 and length > 0:
        constructed_password = ''.join(secrets.choice(character_set) for i in range(length))
    else:
        check_return("You did not enter any characters to choose from!\n\
Your password could not be constructed\nbased on your selections")

    return constructed_password

def percentage():
    '''
    Function to calculate and format
    a percentage given a numerator and
    denominator
    '''
    print_head()
    print("Please use only integers with this function")
    numerator = check_input(int, 'Please enter the numerator: ')
    denominator = check_input(int, 'Please enter the denominator: ')
    places = check_input(int, 'How many decimal places would you like: ')

    calculated_percentage = (numerator/denominator)
    formatted = "{:.{places_after}%}".format(calculated_percentage, places_after=places)
    check_return(str(numerator)+"/"+str(denominator)+" = "+str(formatted))


def daysto4july():
    '''
    fucntion to calculate the number of days
    from today until july 4th 2025
    '''
    print_head()
    date_future = datetime.date(2025, 7, 4)
    date_today = datetime.date.today()
    days_between = date_future - date_today
    check_return("There are "+str(days_between.days)+" days between today and 4 July 2025.")

def triangle():
    '''
    Function to take input for the calculation
    of an unknown leg of a triangle using the
    law of cosines
    '''
    print_head()
    print('You may use integers or floats with this function.')
    hyp = check_input(float, 'Please enter the hypoteneuse of the triangle: ')
    adj = check_input(float, 'Please enter the adjacent leg of the triangle: ')
    ang = check_input(float, 'Please enter the angle that\
 is opposite the unknown leg in degrees: ')
    if hyp > 0 and adj > 0 and ang > 0:
        check_return("The length of the unknown leg is "+str(triangle_cosine(hyp, adj, ang)))
    else:
        check_return("You must enter positive numbers for these measurements!")

def triangle_cosine(hypoteneuse, adjacent, angle):
    '''
    takes three properties of a triangle and calculates
    the unknown leg based on the two known legs, one
    angle, and the law of cosines
    parameters:
        hypoteneuse (float) lenght of the hypoteneuse
        adjacent (float) length of the adjacent leg
        angle (float) degree measurement of the opposite angle
    returns
        length (float) length of the unknown side
    '''
    radian_angle = math.radians(angle)
    return math.sqrt((hypoteneuse**2 + adjacent**2) -\
 ((2 *  hypoteneuse * adjacent) * math.cos(radian_angle)))

def cylinder():
    '''
    Function to calculate the volume
    of a right cylinder
    '''
    print_head()
    print('You may use integers or floats with this function.')
    radius = check_input(float, 'Please enter the radius of the cylinder: ')
    height = check_input(float, 'Please enter the height of the cylinder: ')
    if radius > 0 and height > 0:
        check_return(math.pi * radius**2 * height)
    else:
        check_return("You must enter positive numbers for these measurements!")

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
    choice_count = 0
    while True:
        choice = input('Make a choice from the menu above-----> ')
        check_quit(choice)
        if choice == '1':
            menu_screen()
        elif choice == '2':
            leave_program("Goodbye! Thanks for using my app.")
        else:
            if choice_count < 2:
                print("Make better choices!")
                choice_count += 1
            else:
                leave_program("You made too many bad choices. \nGoodbye!")

def menu_screen():
    '''
    function to take the user's choice
    and run that choice through a switch
    to choose which function to run
    '''

    choosing = True
    choice_count = 0
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
            if choice_count < 2:
                print("XX-->You made an invalid choice<--XX")
                input("XX-->  Press Enter to continue <--XX")
                choice_count += 1
            else:
                leave_program("You made too many bad choices at the menu! Goodbye.")

print_head()
menu_screen()
