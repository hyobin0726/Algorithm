T = int(input())
for test_case in range(1, T + 1):
  n=int(input())
  price=list(map(int,input().split()))
  sum=0
  last=price[-1]

  for i in range(len(price)-2,-1,-1):
    if last>price[i]:
      sum+=(last-price[i])
    else:
      last=price[i]

  print("#{} {}".format(test_case, sum))