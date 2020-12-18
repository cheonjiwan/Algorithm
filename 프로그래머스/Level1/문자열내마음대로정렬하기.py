def solution(strings, n):
    strings=sorted(strings,key=lambda x: (x[n],x))
    return strings
