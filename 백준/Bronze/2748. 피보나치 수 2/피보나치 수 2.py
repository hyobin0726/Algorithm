n=int(input())
f=[0]*91

def fibo(x):
    if x==0 :
        return 0
    if x==1:
        return 1
    if f[x] == 0:
        f[x]=fibo(x-1)+fibo(x-2)
    return f[x]
print(fibo(n))