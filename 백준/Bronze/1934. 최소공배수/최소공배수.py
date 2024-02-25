t = int(input())
for i in range  (t):
    a, b =map(int,input().split())
    c= a%b

    temp_a=a
    temp_b=b

    while c != 0 :
        a=b
        b=c
        c=a%c
    print((temp_a*temp_b)//b)