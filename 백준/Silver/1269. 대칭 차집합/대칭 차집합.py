a,b=map(int,input().split())
n=set(map(int,input().split()))
m=set(map(int,input().split()))

print(len(n-m)+len(m-n))