import sys
input=sys.stdin.readline

#이미 심어진 가로수 수
n=int(input())
#이미 심어진 가로수
a=[]
for i in range(n):
    a.append(int(input()))
#가로수 간 간격
interval=[]
for i in range(n-1):
    interval.append(a[i+1]-a[i])

def gcd(x,y): #최대공약수, 유클리드 호제
    mod = x % y
    while mod >0:
        x = y
        y = mod
        mod = x % y
    return y

temp=interval[0]
for i in range(1,len(interval)):
    temp=(gcd(temp,interval[i]))

#새로 심을 가로수
cnt=0
for i in interval:
    cnt+= i//temp -1

print(cnt)
