#나는야 포켓몬 마스터 이다솜
import sys
input = sys.stdin.readline

n,m=map(int,input().split())
pocket={}

for i in range (1,n+1):
    a=input().rstrip()
    pocket[i]=a
    pocket[a]=i

for i in range(m):
    question=input().rstrip()
    if question.isdigit():
        print(pocket[int(question)])
    else:
        print(pocket[question])


