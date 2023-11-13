T=int(input())
for tc in range(1,T+1):
    num=input()
    r_min = int(num)
    r_max= int(num)
    a=[]
    for i in range (len(num)-1):
        for j in range(i,len(num)):
            a=list(num)
            a[i],a[j] = a[j],a[i]
            number =''.join(a)
            if number[0] == '0':
                continue
            if int(number) > r_max:
                r_max = int(number)
            if int(number) < r_min:
                r_min = int(number)

    print("#{} {} {}".format(tc,r_min,r_max))


