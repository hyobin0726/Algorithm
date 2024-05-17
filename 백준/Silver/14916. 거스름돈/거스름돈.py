n=int(input())
coin=[5,2]
ans=[]
for i in range (1,n//5+2):
    cnt=0
    if n//(5*i) > 0:
       a=n-(5*i)
       cnt +=i
       if a == 0 :
           ans.append(cnt)
       if a % 2 == 0 :
           cnt+= a//2
           ans.append(cnt)
    else :
        if n % 2 == 0 :
            cnt += n//2
            ans.append(cnt)
if ans:
    print(min(ans))
else:
    print(-1)