import pandas as pd

a = pd.read_csv("weekthree/states.csv")

a.to_html("states.htm")