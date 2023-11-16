for tc in range(1,11):
    n=int(input())
    a=list(map(int,input().split()))
    for i in range(n):
        a[a.index(max(a))]= max(a)-1
        a[a.index(min(a))] = min(a) + 1
    print("#{} {}".format(tc,max(a)-min(a)))
  