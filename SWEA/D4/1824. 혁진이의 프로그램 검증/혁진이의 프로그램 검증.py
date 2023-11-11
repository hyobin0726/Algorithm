def solution(data,visit, test, r, c):
  #상하좌우
  dx=[-1,1,0,0]
  dy=[0,0,-1,1]
  #시작 값 (행,열,방향,메모리)
  stack =[[0,0,3,0]]
  
  while stack :   
    x,y,d,m = stack.pop()
    #이전과 같은 값을 가졌다면 무한 루프
    if visit[x][y][d][m] == test :
      continue
      
    else:
      visit[x][y][d][m] = test
      
      if data[x][y] == '@':
        return True
      elif data[x][y] == '+':
        stack.append([(x+dx[d])%r ,(y+dy[d])%c ,d,(m+1)%16])
      elif data[x][y] == '-':
        stack.append([(x+dx[d])%r ,(y+dy[d])%c ,d,(m-1)%16])
      elif data[x][y] == '.':
        stack.append([(x+dx[d])%r ,(y+dy[d])%c ,d,m])
      elif data[x][y] == '?':
        for i in range(4):
          stack.append([(x+dx[i])%r ,(y+dy[i])%c ,i,m])
      
      elif data[x][y] == '>' or (data[x][y] == '_' and m == 0):
        stack.append([(x+dx[3])%r ,(y+dy[3])%c ,3,m]) 
      elif data[x][y] == '<' or (data[x][y] == '_' and m != 0):
        stack.append([(x+dx[2])%r ,(y+dy[2])%c ,2,m])
      elif data[x][y] == '^' or (data[x][y] == '|' and m != 0):
        stack.append([(x+dx[0])%r ,(y+dy[0])%c ,0,m])
      elif data[x][y] == 'v' or (data[x][y] == '|' and m == 0):
        stack.append([(x+dx[1])%r ,(y+dy[1])%c ,1,m])
      else: 
        stack.append([(x+dx[d])%r ,(y+dy[d])%c ,d,int(data[x][y])])
  return False


T= int(input())
visit = [[[[0 for _ in range(16)] for _ in range(4)] for _ in range(20)] for _ in range(20)]

for test in range(1, T+1):
  r, c = map(int, input().split())#행, 열
  data= [] #입력받은 데이터
  for i in range(r) :  
    data.append(list(input()))  
  answer =solution(data,visit, test, r,c)

  if answer == True:
    answer = 'YES'
  else:
    answer = 'NO'
  print("#{} {}".format(test, answer))