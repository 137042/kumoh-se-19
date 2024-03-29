from sklearn import datasets
from sklearn.model_selection import train_test_split
import numpy as np
import datetime

print('20191203 최혜민', datetime.datetime.now())
iris = datasets.load_iris()
X = iris.data
y = iris.target
x_train, x_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)
# x_train, x_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0, stratify=y)
_, c_test = np.unique(y_test, return_counts=True)
_, c_train = np.unique(y_train, return_counts=True)
print(c_test)
print(c_train)
print(c_test/(c_train + c_test))
