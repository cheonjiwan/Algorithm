def preprocessing(str1,str2):
    str1=str1.lower();str2=str2.lower()

    set_a=[];set_b=[]
    for i in range(len(str1)-1):
        if ord('a')<=ord(str1[i])<=ord('z') and ord('a')<=ord(str1[i+1])<=ord('z'):
            set_a.append(str1[i]+str1[i+1])
    for i in range(len(str2)-1):
        if ord('a')<=ord(str2[i])<=ord('z') and ord('a')<=ord(str2[i+1])<=ord('z'):
            set_b.append(str2[i]+str2[i+1])

    return set_a,set_b

def solution(str1, str2):
    set_a,set_b=preprocessing(str1,str2)

    intersection=[];union=[]
    while set_a:
        tmp=set_a.pop()
        if tmp in set_b:
            cnt_a=set_a.count(tmp)+1
            cnt_b=set_b.count(tmp)
            if cnt_a>=cnt_b:
                for _ in range(cnt_b):
                    intersection.append(tmp)
                for _ in range(cnt_a):
                    union.append(tmp)
            else:
                for _ in range(cnt_a):
                    intersection.append(tmp)
                for _ in range(cnt_b):
                    union.append(tmp)
            for _ in range(cnt_a-1):
                set_a.remove(tmp)
            for _ in range(cnt_b):
                set_b.remove(tmp)
        else: union.append(tmp)
    while set_b:
        union.append(set_b.pop())

    if len(union)==0 and len(intersection)==0: return 65536
    else:
        return int((len(intersection)/len(union))*65536)

str1='handshake'
str2='shake hands'
print(solution(str1,str2))