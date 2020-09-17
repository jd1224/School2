'''
Module to display a user friendly menu
used to analyze the data of the two provided csv files
will also take cli arguments to assign different files
'''
import platform
from os import system
import sys
from analyzer import Analyzer

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
    for file_in in files:
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
    '''
    Function to parse the headers from the
    dataframe and display the ones that are
    contain numeric data as potential choices.
    allows the user to choose a column for analysis
    parameters:
        data dataframe to be analyzed
        files list of available data frames to pass
            back to menu_one
    '''
    print_head()
    print('----------------------------------------------')
    print(data.name.center(46, '-'))
    print('-  Choose a column to analyze from the list  -')
    print('----------------------------------------------')
    headers = data.headers()
    counter = 1
    header_list = {}
    #check if columns are numeric
    for header in headers:
        if data.type_check(header):
            #print formatted columns in menu style
            print(f'{counter}. {header.title()}')
            #add to dict to reference by counter number later
            header_list[counter] = header
            #increment the counter to use as the next key
            counter += 1
    #print the highest number as the go back function
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

def display(data, col, files):
    '''
    Function to retrieve and display all of the data
    from a chosen dataframe and column
    Parameters:
        data dataframe to be analyzed
        col column name to be analyzed
        files list of files to pass back at the end
    '''
    print_head()
    col_title = f'{col.title()} Column'
    print('----------------------------------------------')
    print(data.name.center(46, '-'))
    print(col_title.center(46, '-'))
    print('----------------------------------------------')
    #Retrieve and print the fomatted output for the functions
    print(f'cols of Data: {data.col_count(col)}\n\
Mean Value: {data.col_mean(col)}\n\
Standard Deviation: {data.col_std(col)}\n\
Minimum Value: {data.col_min(col)}\n\
Maximum Value: {data.col_max(col)}')
    input('Press enter to see a histogram of this data:')
    #display a histogram of the data
    data.histogram(col)
    menu_two(data, files)

def file_list_builder():
    '''
    Function to build the list of files that will be
    passed into the menu_one to start the program.
    '''
    #list of default files
    listeroo = ['data/Housing.csv', 'data/PopChange.csv']
    #if any command line arguments are entered, parse them
    #and add them to the list
    if len(sys.argv) > 1:
        for i in range(1, len(sys.argv)):
            listeroo.append(sys.argv[i])
    out_list = []
    #loop to attempt to create new Analyzers
    for i in listeroo:
        try:
            i = Analyzer(i)
            out_list.append(i)
        #accept errors and move on with the loop
        except FileNotFoundError:
            input(f"{i.split('/')[-1]} could not be found.")
        except PermissionError:
            input(f"{i.split('/')[-1]} permission denied.")
        except Exception as e_x:
            input(f"{i.split('/')[-1]} Unkown Exception\n{e_x}")
    return out_list

if __name__ == "__main__":
    file_listeroo = file_list_builder()
    menu_one(file_listeroo)
