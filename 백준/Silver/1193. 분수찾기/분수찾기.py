x=int(input())
line=0
cnt=0
for i in range (1,x+1):
    cnt+=i
    line+=1
    if cnt >= x :
        break

top=0
bottom=0
#짝수일때
if line%2 == 0:
    top = (line - cnt + x)
    bottom = (cnt - x + 1)

#홀수일때
else:
    top = (cnt - x + 1)
    bottom = (line - cnt + x)

print(top,"/",bottom,sep='')