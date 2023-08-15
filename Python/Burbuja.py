"""
Bubble sort algorithm
"""

n = int(input("Digite la dimensión del vector "))# get vector dimension
v = []

for i in range(0,n):# read vector
    v.append(int(input(f"Ingrese v({i}) ")))

print(f"Los elementos sin ordenear ascendetemente son:{v}")# print unsorted vector


#Sort
for i in range(0,n-1):
    for j in range(0,n-i-1):
        print(v[j])
        if v[j] > v[j+1]:#swap
            t = v[j]
            v[j] = v[j+1]
            v[j+1] = t
        
print(f"Los elementos ordenados ascendetemente son:{v}") #print vector sorted
