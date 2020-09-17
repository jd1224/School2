'''
Module to display a user friendly menu
used to analyze the data of the two provided csv files
will also take cli arguments to assign different files
'''
from population import Analyzer
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
    print('**********************************************')
    print('**     Welcome to the Analyzer Program      **')
    print('** You can quit at any time by entering -q  **')
    print('**********************************************')


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
                leave_program("You made too many bad choices!")
    return variable

def menu_one(files):
    '''
    Splash screen for the program
    asks the user to choose one of the
    supplied files to be analyzed
    '''
    print_head()
    print('----------------------------------------------')
    print('-Choose a file to analyze from the list below-')
    print('----------------------------------------------')
    counter = 1
    file_list = {}
    for count, file_in in enumerate(files):
        print(f'{counter}. {file_in}')
        file_list[counter] = file_in
        counter += 1
    print('----------------------------------------------')
    choice_count = 0
    choosing = True
    while choosing:
        if choice_count < 2:
            choice = check_input(int, 'Choose from the available files --> ')
            if choice < counter:
                menu_two(file_list[choice], files)
            else:
                print("You made an unrecognized choice.")
                choice_count += 1
        else:
            leave_program("You made too many bad choices!")

def menu_two(data, files):
    print_head()
    print('----------------------------------------------')
    print(data.name.center(46,'-'))
    print('-  Choose a column to analyze from the list  -')
    print('----------------------------------------------')
    headers = data.headers()
    counter = 1
    header_list = {}
    for count, header in enumerate(headers):
        if data.type_check(header):
            print(f'{counter}. {header.title()}')
            header_list[counter] = header
            counter += 1
    print(f'{counter}. Go Back <--')
    choice_count = 0
    choosing = True
    while choosing:
        if choice_count < 2:
            choice = check_input(int, 'Choose from the available columns --> ')
            if choice < counter:
                display(data, header_list[choice], files)
            elif choice == counter:
                menu_one(files)
                choosing = False
            else:
                print("You made an unrecognized choice.")
                choice_count += 1
        else:
            leave_program("You made too many bad choices!")


def display(data, row, files):
    print_head()
    row_title = f'{row.title()} Column'
    print('----------------------------------------------')
    print(data.name.center(46,'-'))
    print(row_title.center(46,'-'))
    print('-  Choose a column to analyze from the list  -')
    print('----------------------------------------------')
    print(f'Rows of Data: {data.row_count(row)}\n\
Mean Value: {data.row_mean(row)}\n\
Standard Deviation: {data.row_std(row)}\n\
Minimum Value: {data.row_min(row)}\n\
Maximum Value: {data.row_max(row)}')
    input('Press enter to see a histogram of this data:')
    data.histogram(row)
    menu_two(data, files)

def file_list_builder():
    listeroo = ['data/Housing.csv', 'data/PopChange.csv']
    bad_list =[]
    if len(sys.argv)>1:
        for i in range(1,len(sys.argv)):
            listeroo.append(sys.argv[i])
    out_list = []
    for i in listeroo:
        try:
            i = Analyzer(i)
            out_list.append(i)
        except Exception as e:
            input(f"{i} could not be used.")
    return out_list


file_list = file_list_builder()
menu_one(file_list)
