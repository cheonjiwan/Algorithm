def solution(s):
    answer=[]
    s=s.lstrip('{').rstrip('}').split('},{')
    new_arr = []
    for i in s:
        new_arr.append(i.split(','))
    new_arr.sort(key=len)

    for i in new_arr:
        for j in range(len(i)):
            if int(i[j]) not in answer:
                answer.append(int(i[j]))

    return answer