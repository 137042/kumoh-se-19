import datetime

# def f():
#     x = 45
#     def g():
#         x = 145
#         print(x)  # 145
#
#     g()
#     print(x)  # 45
#
# x = 3
# f()
# print(x)  # 3


# def f():
#     x = 45
#     def g():
#         global x
#         x = 145
#         print(x)  # 145
#
#     g()
#     print(x)  # 45
#
# x = 3
# f()
# print(x)  # 145


# def f():
#     x = 45
#     def g():
#         nonlocal x
#         x = 145
#         print(x)  # 145

#     g()
#     print(x)  # 145

# x = 3
# f()
# print(x)  # 3

# tuple1 = (1, 2, 3, 4, 5, 6, 7, 8, 9)
# tuple2 = tuple1[0::2]
# sum = 0
# for x in tuple2:
#     sum += x
# print(tuple2, "평균 : ", str(sum/len(tuple2)))


# 행렬 덧셈
print('20191203 최혜민', datetime.datetime.now())
A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
B = [[9, 8, 7], [6, 5, 4], [3, 2, 1]]

# 방법 1
C = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
for r in range(0, len(A)) :
    for c in range(0, len(A[r])):
        C[r][c] = A[r][c] + B[r][c]
print(C)

# 방법 2
C = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
C = [[A[i][j] + B[i][j] for j in range(len(A[i]))] for i in range(len(A))]
print(C)


# 행렬 덧셈 - 튜플 버전
print('20191203 최혜민', datetime.datetime.now())
A = ((1, 2, 3), (4, 5, 6), (7, 8, 9))
B = ((9, 8, 7), (6, 5, 4), (3, 2, 1))

C = [[A[i][j] + B[i][j] for j in range(len(A[0]))] for i in range(len(A))]
C = tuple(C) # C = [tuple(l) for l in C]
print(C)
