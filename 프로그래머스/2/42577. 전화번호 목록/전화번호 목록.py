def solution(phone_book):
    answer = True
    phone_book.sort()
    cnt=0
    
    for i in range(cnt+1,len(phone_book)):
        a=phone_book[cnt]
        b=phone_book[i]
        
        for j in range(1,len(a)+1):
            if a[:j] != b[:j]:
                cnt+=1
                break
            elif a== b[:len(a)] :
                answer = False
                break
        

    return answer