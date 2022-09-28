import numpy as np
from sklearn import datasets
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import StandardScaler
from sklearn.svm import LinearSVC
from sklearn.datasets import make_moons
from sklearn.pipeline import Pipeline
from sklearn.preprocessing import PolynomialFeatures
from sklearn.svm import SVC
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.multiclass import OneVsOneClassifier, OneVsRestClassifier
from sklearn.svm import LinearSVC
from sklearn import metrics
from sklearn.datasets import load_iris
from sklearn.tree import DecisionTreeClassifier
import datetime
import warnings

warnings.filterwarnings('ignore')  
iris = datasets.load_iris()
X = iris["data"][:, (2, 3)] # petal length, petal width
y = (iris["target"] == 2).astype(np.float64) # Iris-Virginica

# p28 sklearn SVM
svm_clf = Pipeline((
("scaler", StandardScaler()),
("linear_svc", LinearSVC(C=1, loss="hinge")),
))
svm_clf.fit(X, y)
predict = svm_clf.predict(X)
print('p28 / 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y, predict), '\n')

# p29 sklearn SVM - Nonlinear SVM Classification
polynomial_svm_clf = Pipeline((
("poly_features", PolynomialFeatures(degree=3)),
("scaler", StandardScaler()),
("svm_clf", LinearSVC(C=10))
))
polynomial_svm_clf.fit(X, y)
predict = polynomial_svm_clf.predict(X)
print('p29 / 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y, predict), '\n')

# p30 sklearn - Nonlinear SVM Classification - kernel 1
poly_kernel_svm_clf = Pipeline((
("scaler", StandardScaler()),
("svm_clf", SVC(kernel="poly", degree=3, C=5))))
poly_kernel_svm_clf.fit(X, y)
predict = poly_kernel_svm_clf.predict(X)
print('p30 / 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y, predict), '\n')

# p31 sklearn SVM - Nonlinear SVM Classificatioin - kernel 2
rbf_kernel_svm_clf = Pipeline((
("scaler", StandardScaler()),
("svm_clf", SVC(kernel="rbf", gamma=5, C=0.001))
))
rbf_kernel_svm_clf.fit(X, y)
predict = rbf_kernel_svm_clf.predict(X)
print('p31 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y, predict), '\n')

# p38 sklearn SVM - multiclass classifier - one
X, y = load_iris(return_X_y=True)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, shuffle=True, random_state=0)
clf = OneVsOneClassifier(LinearSVC(random_state=0)).fit(X_train, y_train)
predicted = clf.predict(X_test)
print('p38 - 1 / 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y_test, predicted), '\n')

# p38 sklearn SVM - multiclass classifier - rest
X, y = load_iris(return_X_y=True)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, shuffle=True, random_state=0)
clf = OneVsRestClassifier(LinearSVC(random_state=0)).fit(X_train, y_train)
predicted = clf.predict(X_test)
print('p38 - 2 / 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y_test, predicted), '\n')

# p17 Decision Tree in Scikit-Learn 
iris = load_iris()
X = iris.data[:, 2:]
y = iris.target
tree_clf = DecisionTreeClassifier(max_depth=2)
tree_clf.fit(X, y)
predict = tree_clf.predict(X)
print('p17 / 20191203 최혜민', datetime.datetime.now())
print(metrics.classification_report(y, predict), '\n')
