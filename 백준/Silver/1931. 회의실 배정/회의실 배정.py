import sys
input=sys.stdin.readline
n=int(input())
conference=[]
for i in range (n):
    conference.append(list(map(int,input().split())))
conference.sort(key=lambda x : (x[1],x[0]))

count=1
start=conference[0][0]
end=conference[0][1]

for i in range(1,n):
    if end <= conference[i][0]:
        count+=1
        end=conference[i][1]
print(count)