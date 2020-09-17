import pandas as pd
import matplotlib.pyplot as plt
from population import Analyzer

#Id,Geography,Target Geo Id,Target Geo Id2,Pop Apr 1,Pop Jul 1,Change Pop

pop = Analyzer('data/PopChange.csv')

print(pop.type_check('Id'))
'''
    window = Tk()
    window.title(f'{data} Row: {row}')

    frame = Frame(window)
    frame.pack()
    Label(frame, text=f'Rows of Data: {data.row_count(row)}\n\
Mean Value: {data.row_mean(row)}\n\
Standard Deviation: {data.row_std(row)}\n\
Minimum Value: {data.row_min(row)}\n\
Maximum Value: {data.row_max(row)}').pack()
    window.mainloop()

    tkinter.messagebox.showinfo(f'{data} Row {row}', 
    f'Rows of Data: {data.row_count(row)}\n\
Mean Value: {data.row_mean(row)}\n\
Standard Deviation: {data.row_std(row)}\n\
Minimum Value: {data.row_min(row)}\n\
Maximum Value: {data.row_max(row)}')
'''