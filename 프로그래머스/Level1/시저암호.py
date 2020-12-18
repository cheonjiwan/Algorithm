def solution(s, n):
    answer = ''
    lower='abcdefghijklmnopqrstuvwxyz'
    upper='ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    for i in range(len(s)):
        if s[i]==' ': answer+=' ';continue
        if s[i] in lower: answer+=lower[(lower.index(s[i])+n)%len(lower)]
        else: answer+=upper[(upper.index(s[i])+n)%len(upper)]
    return answer
