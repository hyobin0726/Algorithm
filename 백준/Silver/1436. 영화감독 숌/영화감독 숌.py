a=int(input())
cnt=0
b=666

while True:
  if '666' in str(b):
    cnt+=1
    if cnt==a:
      print(b)
      break
  b+=1  
