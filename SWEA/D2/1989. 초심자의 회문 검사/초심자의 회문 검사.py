T=int(input())
for tc in range(1,T+1):
    s=input()
    cnt=0
    for i in range(len(s)):
        if i == len(s)//2:
            break
        if s[i] == s[len(s)-1-i]:
            cnt+=1
    if cnt == (len(s)//2) :
        print("#{} {}".format(tc,'1'))
    else:
        print("#{} {}".format(tc,'0'))

