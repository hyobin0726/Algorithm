def solution(n, lost, reserve):
    student = []
    lost.sort()
    reserve.sort()
    for i in range(1, n+1):
        student.append(i)
        if i in lost:
            student.remove(i)
            if i in reserve:
                student.append(i)
                reserve.remove(i)
                lost.remove(i)
    for i in lost:
        for j in reserve:
            if abs(i-j) == 1:
                student.append(j)
                reserve.remove(j)
                break
    return len(student)