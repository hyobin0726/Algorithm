n=int(input())

num=0

for i in range(1,n+1):
  num = sum((map(int, str(i))))
  num_sum = i + num
  if n == num_sum:
    print(i)
    break
  elif i ==n:
    print(0)