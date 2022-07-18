from sklearn import preprocessing
from sklearn.naive_bayes import GaussianNB
from sklearn.metrics import accuracy_score
import numpy as np
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn import metrics
from sklearn.metrics import accuracy_score
import datetime

# # Play_Tennis 데이터 셋에 네이브 베이즈 분류기를 적용하여 성능 파악하기
# print('20191203 최혜민', datetime.datetime.now())
#
# outlook = ['Sunny', 'Sunny', 'Overcast', 'Rain', 'Rain', 'Rain', 'Overcast',
#            'Sunny', 'Sunny', 'Rain', 'Sunny', 'Overcast', 'Overcast', 'Rain']
# temperature = ['Hot', 'Hot', 'Hot', 'Mild', 'Cool', 'Cool', 'Cool',
#                'Mild', 'Cool', 'Mild', 'Mild', 'Mild', 'Hot', 'Mild']
# humidity = ['High', 'High', 'High', 'High', 'Normal', 'Normal', 'Normal',
#             'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'High']
# wind = ['Weak', 'Strong', 'Weak', 'Weak', 'Weak', 'Strong', 'Strong',
#         'Weak', 'Weak', 'Weak', 'Strong', 'Strong', 'Weak', 'Strong']
#
# playTennis = ['No', 'No', 'Yes', 'Yes', 'Yes', 'No', 'Yes',
#               'No', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes', 'No']
#
# encoder = preprocessing.LabelEncoder()
#
# outlook_encoded = encoder.fit_transform(outlook)
# temp_encoded = encoder.fit_transform(temperature)
# humidity_encoded = encoder.fit_transform(humidity)
# wind_encoded = encoder.fit_transform(wind)
#
# features = zip(outlook_encoded, temp_encoded, humidity_encoded, wind_encoded)
# features = list(features)
# label = encoder.fit_transform(playTennis)
#
# model = GaussianNB()
# model.fit(features, label)
#
# predict = model.predict(features)
# print(accuracy_score(label, predict))


# iris 데이터 셋에 네이브 베이즈 분류기를 적용하여 성능 파악하기
print('20191203 최혜민', datetime.datetime.now())

iris = datasets.load_iris()
x = iris.data
y = iris.target
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=0, stratify=y)
_, c_test = np.unique(y_test, return_counts=True)
_, c_train = np.unique(y_train, return_counts=True)

gnb = GaussianNB()
gnb.fit(x_train, y_train)

expected = y_test
predicted = gnb.predict(x_test)
print(metrics.classification_report(y_test, predicted))