'''
State Program
This program will read a csv file with the data
State,Captial,Flower,Population
and create a list of State objects.
Users can then accomplish the commands in the
user specifications from the projectthree document.
'''
import platform
from os import system
import sys
import csv
from state import State
import matplotlib.pyplot as plt
import matplotlib.image as mplimg
import seaborn as sns

STATE_FILE = "states.csv"
STATE_LIST = []


def print_head():
    '''
    prints the head of the program
    with instructions on how to exit
    the program
    '''
    clear_screen()
    print('**********************************************')
    print('** Welcome to the state data Application    **')
    print('** Make a selection from the menu below     **')
    print('** You can quit at any time by entering -q  **')
    print('**********************************************')
    print('----------------------------------------------')


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
    write_state_file()
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

        leave_program('You have entered -q to quit. '\
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
                check_return()
    return variable

def fill_states():
    '''
    function to read in the csv of state stats
    and return a list of state objects
    '''

    with open(STATE_FILE, 'r') as infile:
        for line in csv.reader(infile):
            STATE_LIST.append(State(line[0], line[1], line[2], line[3]))

def check_return():
    '''
    Function to display the output of the previous function
    and ask the user if they want to return to the menu or
    quit the program.
    '''

    print('\n')
    print("Would you like to return to the menu?")
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
        if choice_count < 2:
            if choice == '1':
                menu_screen()
            elif choice == '2':
                leave_program("Goodbye! Thanks for using my app.")
            else:
                print("You made an unrecognized choice.")
                choice_count += 1
        else:
            leave_program("You made too many bad choices!")

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

        print('1. List of States')
        print('2. Search for a State')
        print('3. Top 5 States by Population')
        print('4. Upadte a Population')
        print('\n')

        choice = input('Make a choice from the menu above-----> ')
        check_quit(choice)


        if choice == '1':
            print_states()
            choosing = False
        elif choice == '2':
            state_viewer(choose_state())
            choosing = False
        elif choice == '3':
            top_five_by_population()
            choosing = False
        elif choice == '4':
            update_population(choose_state())
            choosing = False
        else:
            if choice_count < 2:
                print("XX-->You made an invalid choice<--XX")
                input("XX-->  Press Enter to continue <--XX")
                choice_count += 1
            else:
                leave_program("You made too many bad choices!")

    check_return()

def print_states():
    '''
    print a formatted list of the states
    parameters:
        list of State objects to print
    '''
    print_head()
    print('**********************************************************************')
    print('----------------------------------------------------------------------')
    print("** {:<15}".format("State")+"{:<15}".format("Capital")+"{:<25}"\
.format("Flower")+"{:<25}".format("Population"))
    print('----------------------------------------------------------------------')
    for i in STATE_LIST:
        name = i.name
        cap = i.capital
        population = i.population
        flower = i.flower
        print("** {:<15}".format(name)+"{:<15}".format(cap)+"{:<25}"\
.format(flower.title())+format(int(population), ",d"))
    print('***********************************************************************')


def choose_state():
    '''
    choose a state to view the statistics
    and a picture of the state flower
    '''
    print_head()
    state_choice = ''
    choice_count = 0
    choosing = True
    while choosing:
        choice = input("Please choose a state: ").lower()
        check_quit(choice)
        for i in STATE_LIST:
            if i.name.lower() == choice:
                state_choice = i
                choosing = False
        if not isinstance(state_choice, State):
            if choice_count < 2:
                print("Your choice is not a valid US State.")
                choice_count += 1
            else:
                print_head()
                print("You made too many bad choices!")
                check_return()
    return state_choice




def state_viewer(state):
    '''
    function to display the stateistice
    of the chosen state and pop up a
    picture of the flower
    '''
    try:
        name = state.name
        cap = state.capital
        population = state.population
        flower = state.flower
    except AttributeError:
        print("Your selection was not found.\n\
Please enter a valid US State next time!")
        return
    try:
        #try to display the information in a matplotlib frame with a title
        matflower = mplimg.imread(f'images/{flower}.jpg')
        img_plot = plt.imshow(matflower)
        plt.title(f"{name}'s state flower is the {flower.title()}.\n\
The capital is {cap}, and the state's population is {int(population):,}")
        plt.axis("off")
        plt.show()
    except FileNotFoundError:
        #show the commandline output if no picture is available for the flower of the state
        print_head()
        print('**********************************************************************')
        print('----------------------------------------------------------------------')
        print("** {:<15}".format("State")+"{:<15}".format("Capital")+"{:<25}"\
.format("Flower")+"{:<25}".format("Population"))
        print('----------------------------------------------------------------------')
        print("** {:<15}".format(name)+"{:<15}".format(cap)+"{:<25}"\
.format(flower.title())+format(int(population), ",d"))
        print('----------------------------------------------------------------------')
        print('-An image of the state flower is not available for the chosen state  -')

def top_five_by_population():
    '''
    function to order the states by population
    and return the top five
    parameters:
        list of states to order by population
    returns:
        list of top five states by population
    '''
    print_head()
    pop_list = []
    #create a list of tuples containing each state and population
    for i in STATE_LIST:
        pop_list.append((i.name, i.population))
    #sort the list of tuples based on the second value in the tuple
    pop_list = sorted(pop_list, key=lambda state: int(state[1]))
    #get the top five tuples using a negative index
    top_pop = pop_list[len(pop_list)-5:]
    #break the tuples into two lists suitable for seaborn to work with
    names = []
    values = []
    for i in top_pop:
        names.append(i[0])
        values.append(int(i[1])/10000)
    #create the table of data and format it using seaborn/matplotlib
    title = "Top Five States by Population"
    sns.set_style('whitegrid')
    axes = sns.barplot(x=names, y=values, palette='bright')
    axes.set_title(title)
    axes.set(ylabel="Population x 10000")
    axes.set_ylim(top=max(values) * 1.10)
    #assign total number labels to each bar
    for box, value in zip(axes.patches, values):
        text_x = box.get_x() + box.get_width() / 2.0
        text_y = box.get_height()
        text = f'Total\n{int(value) * 10000:,}'
        axes.text(text_x, text_y, text, fontsize=11, ha='center', va='bottom')
    plt.show()

def write_state_file():
    '''
    function to write the state list to
    the state file. this allows persistent
    changes based on the update of population
    data function.
    '''

    with open(STATE_FILE, 'w+', newline='') as outfile:
        for i in STATE_LIST:
            csv.writer(outfile).writerow(i.get_list())
        outfile.close()


def update_population(state):
    '''
    Function to update the population of the given state
    parameters:
        State object to be updated
    '''
    try:
        name = state.name
        population = state.population
    except AttributeError:
        print("Your state was not found! Please try again.")
        check_return()

    print_head()
    print(name+"'s current population is: "+format(int(population), ",d"))
    state.population = check_input(int, "What would you like to change the population to? ")
    print(name+"'s population has been updated!")



clear_screen()
fill_states()
menu_screen()
