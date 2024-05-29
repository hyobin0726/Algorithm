n=int(input())
f=[0]*21
f[0]=0
f[1]=1
def fibo(n):
    for i in range(2,n+1):
        if f[i] ==0 :
            f[i]=f[i-1]+f[i-2]

    return f[n]
print(fibo(n))