import pandas as pd
from apyori import apriori
import datetime

print('20191203 최혜민', datetime.datetime.now())
store_data = pd.read_csv('C:/Users/mare1/workspace/ai-practice/store_data.csv', header=None)

records = []
for i in range(0, 7501):
    records.append([str(store_data.values[i,j]) for j in range(0, 20)])

association_rules = apriori(records, min_support=0.0045, min_confidence=0.2, min_lift=3, min_length=2)
association_results = list(association_rules)

for item in association_results:
    print(item[0])
    items = [x for x in item[0]]
    
    print(items[0] + " -> " + items[1])
    print("support = " + str(item[1]))
    print("confidence = " + str(item[2][0][2]))
    print("lift = " + str(item[2][0][3]))
    print()