n,m = map(int,input().split())
board=[]
for i in range(n):
  board.append(input())
result=[]

for i in range(n-7):
  for j in range(m-7):
    w_idx=0
    b_idx=0
    for k in range(i,i+8):
      for l in range(j,j+8):
        if (k+l)%2==0:#짝수인경우
          if board[k][l]!='W':
            w_idx+=1
          else:
            b_idx+=1
        else: #홀수인경우
          if board[k][l]!='W':
            b_idx+=1
          else:
            w_idx+=1
    result.append(w_idx)
    result.append(b_idx)
    
print(min(result))