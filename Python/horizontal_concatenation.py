"""
Given two matrices A and B, the task is joining A with B
matrices to make a new matrix.
This case will be [A B]
"""
import numpy as np

A = np.empty((100,100))
B = np.empty((100,100))
C = np.empty((200,200))

#Read dimensions
n = int(input("Digita la dimensión en n"))
m = int(input("Digita la dimensión en m"))
q = int(input("Digita la dimensión en q"))

#Read matrices
for i in range(n):
    for j in range(m):
        A[i,j] = int(input(f"Digita el elemento de A[{i},{j}]"))

for i in range(n):
    for j in range(q):
        B[i,j] = int(input(f"Digita el elemento de B[{i},{j}]"))


#Show them
print("A")
print(A[:n,:m])
print("B")
print(B[:n,:q])


#Joining!
for i in range(n):
    for j in range(m+q):
        if j < m:
            C[i,j] = A[i,j]
        else:
            C[i,j] = B[i, j-m]

#Show [A B]
print("[A,B]")
print(C[:n,:m+q])