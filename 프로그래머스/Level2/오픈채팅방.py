def solution(record):
    mydic={};result=[]
    for item in record:
        tmp=item.split(' ')
        if tmp[0]=='Enter' or tmp[0]=='Change':
            mydic[tmp[1]]=tmp[2]
        if tmp[0]!='Change':
            result.append((tmp[0],tmp[1]))
    answer=[]
    for item in result:
        message=''
        what,who=item
        if what=='Enter': message=mydic[who]+'님이 들어왔습니다.'
        elif what=='Leave': message=mydic[who]+'님이 나갔습니다.'
        answer.append(message)
    return answer