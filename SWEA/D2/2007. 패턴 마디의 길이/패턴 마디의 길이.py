T=int(input())
for tc in range(1,T+1):
    s=input()
    cnt=""
    for i in range(1,len(s)):
        if s[0:i] == s[i:i+i]:
            cnt=s[0:i]
            break
    print("#{} {}".format(tc, len(cnt)))