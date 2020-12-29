def solution(s):
    answer='';flag=True
    for i in range(len(s)):
        if flag and s[i]!=' ': answer+=s[i].upper();flag=False
        else:
            if s[i]==' ': answer+=s[i];flag=True
            else: answer+=s[i].lower()
    return answer

# python 내장 함수로 title()를 사용하면 앞 글자만 바꿔준다고 합니다,,,