#후위 표기식2
n=int(input())
#후위표기식
postfix=list(input())
num  = [0]*n
for i in range(n):
    num[i] = int(input())

stack=[]
for i in postfix:
  if 'A' <= i <= 'Z':
      stack.append(num[ord(i)-ord('A')])
  else:
      a= stack.pop()
      b=stack.pop()

      if i =='+':
          stack.append(b+a)
      elif i =='-':
          stack.append(b-a)
      elif i =='*':
          stack.append(b*a)
      elif i == '/':
          stack.append(b/a)
print('%.2f' %stack[0] )