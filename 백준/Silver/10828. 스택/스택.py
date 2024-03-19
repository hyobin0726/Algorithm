import sys
input=sys.stdin.readline
n=int(input())
arr=[]
for i in range (n):
    a=input().split()
    if a[0]=='push':
        arr.append(a[1])
    elif a[0]=='pop':
        if arr :
            print(arr.pop())
        else:
            print(-1)
    elif a[0]=='size':
        print(len(arr))
    elif a[0]=='empty':
        if arr :
            print(0)
        else:
            print(1)
    elif a[0]=='top':
        if arr:
            print(arr[-1])
        else:
            print(-1)