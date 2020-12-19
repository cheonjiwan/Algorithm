def solution(s):
    idx=0;answer=''
    for i in range(len(s)):
        if s[i]==' ': answer+=s[i];idx=0;continue
        if idx%2==0: answer+=s[i].upper()
        else: answer+=s[i].lower()
        idx+=1
    return answer

s="Hello eVeryone"
print(solution(s))