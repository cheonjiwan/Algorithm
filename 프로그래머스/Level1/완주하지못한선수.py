def solution(participant, completion):
    answer = ''
    mydic={};cnt=0
    for who in participant:
        if who not in mydic: mydic[who]=1
        else: mydic[who]+=1
    
    for who in completion:
        mydic[who]-=1

    for who in participant:
        if mydic[who]!=0:
            return who

participant=['mislav', 'stanko','mislav', 'ana']
completion=['stanko', 'ana', 'mislav']
print(solution(participant,completion))