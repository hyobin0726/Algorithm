t=int(input())
for i in range(t):
    vps = input()
    vps_list=[]

    for i in range(len(vps)):
        if vps[i]=="(":
            vps_list.append(vps[i])
        else:
            if len(vps_list) == 0 :
                vps_list.append('end')
                break
            vps_list.pop()
    if len(vps_list)==0 :
        print('YES')
    else:
        print('NO')