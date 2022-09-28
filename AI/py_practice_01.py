import datetime
import random

# 소속 연산자 실습하기
print('20191203 최혜민', datetime.datetime.now())

testStr = "i love you"
z = 'i' in testStr; print(z)
z = "love" in testStr; print(z)
z = "Love" in testStr; print(z)

testTuple = (1, 2, (3, 4))
z = 1 in testTuple; print(z)
z = (1, 2) in testTuple; print(z)
z = (3, 4) in testTuple; print(z)

testList = [[1, 2], 3, 4]
z = 1 in testList; print(z)
z = [1, 2] in testList; print(z)
z = [3, 4] in testList; print(z)


# 객체 확인 연산자 실습하기
print('20191203 최혜민', datetime.datetime.now())

a = "abc"; b = "abc"; c = "a"; d = 'a'; e = "ab"
z = a is b; print(z)
z = c is d; print(z)
z = a[0] is c; print(z)
z = a[0:2] is e; print(z)

list1 = [1, 2, [3, 4]]; list2 = [3, 4]; list3 = [3, 4]
z = list2 is list3; print(z)
z = list1[2] is list2; print(z)


# 홀짝 맞히기
print('20191203 최혜민', datetime.datetime.now())

x = random.randint(0, 100)
if x % 2 == 0:
    quest = 'e'
else:
    quest = 'o'

guess = input("0과 100 사이의 난수가 하나 생성 되었음. 짝수라 생각하면 e를, 홀수라고 생각하면 o를 입력 : ")
if guess == quest:
    print("축하합니다!!!")
else:
    print("다음 기회에 ...")


# 좌표값의 분면 결정하기
print('20191203 최혜민', datetime.datetime.now())

strX = input("좌표의 x값 >> ")
x = int(strX)
strY = input("좌표의 y값 >> ")
y = int(strY)
if x == 0 or y == 0:
    print("x나 y 중 하나가 0이면 분면을 판단할 수 없습니다.")
elif x > 0:
    if y > 0:
        qud = 1
    else:
        qud = 4
    print("좌표 (" + str(x) + ", " + str(y) + ")의 분면은 " + str(qud) + "분면입니다.")
else:
    if y > 0:
        qud = 2
    else:
        qud = 3
    print("좌표 (" + str(x) + ", " + str(y) + ")의 분면은 " + str(qud) + "분면입니다.")


# 숫자 맞히기 게임
print('20191203 최혜민', datetime.datetime.now())

quest = random.randint(1, 100)
cont = 'y'
while cont == 'y':
    guess = int(input("예측값 (1과 100 사이) ? "))
    if guess > quest:
        print("정답보다 큽니다.")
    elif guess < quest:
        print("정답보다 작습니다.")
    else:
        print("정답입니다!!!")
    cont = 'n'


# 팩토리얼 구하기
print('20191203 최혜민', datetime.datetime.now())

n = int(input("n의 값을 입력하시오. "))
factorial = 1
for index in range(1, n+1):
    factorial *= index
print("1 ~ " + str(n) + "까지의 곱은 " + str(factorial) + "입니다.")


# 소수 판별하기
print('20191203 최혜민', datetime.datetime.now())

n = int(input("양의 정수 n의 값을 입력하시오. "))
if n == 1:
    print("소수가 아닙니다."); exit(0)
prime = 'y'
for i in range(2, n):
    if n % i == 0:
        prime = 'n'; break
if prime == 'y':
    print("소수입니다.")
else:
    print("소수가 아닙니다.")
