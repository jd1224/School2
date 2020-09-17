'''
Module to define the custom class
Analyzer described below.
'''
import pandas as pd
import matplotlib.pyplot as plt
from pandas.api.types import is_numeric_dtype


class Analyzer:
    '''
    Class to read a csv file and format it into a dataframe
    provides methods to conduct statistical analysis of the
    numeric columns of the data frame
    '''

    def __init__(self, path):
        '''
        initialization function for instantiating the class
        sets the frame data and the name variable
        parameters:
            path str path to the csv file to be
            turned into a dataframe
        '''
        self.path = path
        try:
            self.frame = pd.read_csv(path)
        except FileNotFoundError:
            raise Exception(self.path)

        self.name = f"Analyzer for {(path.split('/'))[-1]}"

    def __str__(self):
        '''
        tostring function to return the name
        '''
        return self.name

    def row_count(self, row):
        '''
        return the row count of the given row
        parameters:
            row to be used in the function
        '''
        return self.frame[row].count()


    def row_mean(self, row):
        '''
        return the mean of the given row
        parameters:
            row to be used in the function
        '''
        return f'{self.frame[row].mean():.2f}'

    def row_std(self, row):
        '''
        return the row standard deviation of the given row
        parameters:
            row to be used in the function
        '''
        return f'{self.frame[row].std():.2f}'

    def row_min(self, row):
        '''
        return the minimum value of the given row
        parameters:
            row to be used in the function
        '''
        return self.frame[row].min()

    def row_max(self, row):
        '''
        return the maximum value of the given row
        parameters:
            row to be used in the function
        '''
        return self.frame[row].max()

    def histogram(self, row):
        '''
        displays a histogram of the given row
        parameters:
            row to be displayed
        '''
        self.frame.hist(row)
        plt.show()

    def headers(self):
        '''
        returns a list of the headers for the
        dat frame
        '''
        return list(self.frame.columns.values)

    def type_check(self, row):
        '''
        returns boolean whether the row is numeric
        parameters:
            row to be checked
        returns:
            bool whether the row is numeric or not
        '''
        return is_numeric_dtype(self.frame[row])
