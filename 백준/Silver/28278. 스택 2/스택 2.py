import sys
input = sys.stdin.readline
n=int(input())
stack=[]

for i in range (n):
    a = input().split()
    if a[0]== "1":
        stack.append(a[1])
    #제거 후 제거한 수 출력
    elif a[0]== "2" :
        if len(stack) >0:
            print(stack.pop())
        else:
            print(-1)
    elif a[0] == "3":
        print(len(stack))

    elif a[0] == "4" :
        if len(stack)==0 :
            print(1)
        else:
            print(0)
    #출력만
    elif a[0]=="5":
        if len(stack) > 0 :
            print(stack[-1])
        else:
            print(-1)