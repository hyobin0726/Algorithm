n=int(input())
stack=[]
answer=[]
temp=1
no=0
for i in range (n):
    num = int(input())
    while temp <= num:
        stack.append(temp)
        answer.append('+')
        temp+=1
    if stack[-1] == num:
        stack.pop()
        answer.append('-')
    else:
        print('NO')
        no=1
        break
if no == 0 :
    for i in answer:
        print(i)