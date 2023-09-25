"""
Given two matrices, the task is to multiply them. 
Matrices can either be square or rectangular:
"""
import numpy as np # We use numpy to simulate stactic structure

A = np.empty((100,100))
B = np.empty((100,100))
C = np.empty((100,100))


n = int(input("Digita la dimensión en n"))
m = int(input("Digita la dimensión en m"))
q = int(input("Digita la dimensión en q"))

#Read matrices
for i in range(n):
    for j in range(m):
        A[i,j] = int(input(f"Digita el elemento de A[{i},{j}]"))

for i in range(m):
    for j in range(q):
        B[i,j] = int(input(f"Digita el elemento de B[{i},{j}]"))


#Show them
print("A")
print(A[:n,:m])
print("B")
print(B[:m,:q])

#Multiply loop!
for i in range(n):
    for j in range(q):
        ac = 0
        for k in range(m):
            ac = ac + A[i,k]*B[k,j]
        C[i,j] = ac

print("AB=C")
print(C[:n,:q])

