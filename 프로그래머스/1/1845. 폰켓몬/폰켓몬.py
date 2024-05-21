def solution(nums):
    answer = 0
    phone=set()
    for i in nums :
        
        if len(phone)<len(nums)//2:
            phone.add(i)
        else:
            break
         
    return len(phone)