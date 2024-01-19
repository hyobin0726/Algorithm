def a(n):
    arr = [1, 1, 1, 2, 2, 3]
    if n >=7:
        for i in range(7,n+1):
            arr.append(arr[i-2]+arr[i-6])
        return arr[n-1]
    else:
        return arr[n-1]
t=int(input())
for i in range(t):
    n=int(input())
    print(a(n))
