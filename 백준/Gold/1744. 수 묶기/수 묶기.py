n=int(input())
m=[]
o=[]
p=[]
for i in range(n):
    a=int(input())
    if a <=0:
        m.append(a)
    elif a == 1 :
        o.append(a)
    else:
        p.append(a)
p.sort()
m.sort(reverse=True)
answer=0
i=len(p)-2
j=len(p)-1
k=len(m)-2
l=len(m)-1
while l>0:
    answer+=(m[k]*m[l])
    k-=2
    l-=2
if len(m)%2 == 1:
    answer+=m[0]
while j>0:
    answer+=(p[i]*p[j])
    i-=2
    j-=2
if len(p)%2 == 1:
    answer+=p[0]
answer+=sum(o)
print(answer)