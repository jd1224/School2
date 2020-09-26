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

        self.frame = pd.read_csv(path)

        self.name = f"Analyzer for {(path.split('/'))[-1]}"

    def __str__(self):
        '''
        tostring function to return the name
        '''
        return self.name

    def col_count(self, col):
        '''
        return the col count of the given col
        parameters:
            col to be used in the function
        '''
        return self.frame[col].count()

    def col_mean(self, col):
        '''
        return the mean of the given col
        parameters:
            col to be used in the function
        '''
        return f'{self.frame[col].mean():.2f}'

    def col_std(self, col):
        '''
        return the col standard deviation of the given col
        parameters:
            col to be used in the function
        '''
        return f'{self.frame[col].std():.2f}'

    def col_min(self, col):
        '''
        return the minimum value of the given col
        parameters:
            col to be used in the function
        '''
        return self.frame[col].min()

    def col_max(self, col):
        '''
        return the maximum value of the given col
        parameters:
            col to be used in the function
        '''
        return self.frame[col].max()

    def histogram(self, col):
        '''
        displays a histogram of the given col
        parameters:
            col to be displayed
        '''
        self.frame.hist(col)
        plt.show()

    def headers(self):
        '''
        returns a list of the headers for the
        dat frame
        '''
        return list(self.frame.columns.values)

    def type_check(self, col):
        '''
        returns boolean whether the col is numeric
        parameters:
            col to be checked
        returns:
            bool whether the col is numeric or not
        '''
        return is_numeric_dtype(self.frame[col])
