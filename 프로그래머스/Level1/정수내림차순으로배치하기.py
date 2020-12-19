def solution(n):
    arr=list(str(n))
    arr.sort(reverse=True)
    return int(''.join(arr))
