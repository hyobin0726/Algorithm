def prime(n):
    for k in range(2,int(n**0.5)+1):
        if n%k==0:
            return False
    return True
t=int(input())
for i in range (t):
    n=int(input())
    if n == 0 or n == 1:
        print(2)
        continue
    while True :
        if prime(n):
            print(n)
            break
        else:
            n+=1