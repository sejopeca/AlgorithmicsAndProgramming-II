"""
Bubble sort algorithm
"""

n = int(input("Type vector dimension"))# get vector dimension
v = []

for i in range(0,n):# read vector
    v.append(int(input(f"Type v({i}) ")))

print(f"Elements that are not ordered in ascending order are:{v}")# print unsorted vector


#Sort
for i in range(0,n-1):
    for j in range(0,n-i-1):
        if v[j] > v[j+1]:#swap
            t = v[j]
            v[j] = v[j+1]
            v[j+1] = t
        
print(f"Elements that are sorted in ascending order are:{v}") #print sorted vector
