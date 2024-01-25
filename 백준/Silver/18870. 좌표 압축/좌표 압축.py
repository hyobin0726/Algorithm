import sys
input=sys.stdin.readline
n=int(input())
n_list=list(map(int,input().split()))

m_list=sorted(set(n_list))

dic = {m_list[i]: i for i in range(len(m_list))}

for i in n_list:

    print(dic[i],end=" ")
