#생태학
import sys
input=sys.stdin.readline
tree=dict()
cnt=0
while True:
    temp = input().rstrip()
    if not temp:
        break
    cnt +=1
    if temp in tree:
        tree[temp] +=1
    else:
        tree[temp]=1
tree=sorted(tree.items())
for key, value in tree:
    per=(value/cnt *100)
    print('%s %.4f'%(key,per))
