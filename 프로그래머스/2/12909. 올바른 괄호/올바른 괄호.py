def solution(s):
    answer = True
    st = []
    for i in range (0, len(s)):
        if s[i] == "(": 
            st.append(s[i])
        else:
            if st :
                st.pop()
            else:
                answer = False
                break
    if st:
        answer = False

    return answer