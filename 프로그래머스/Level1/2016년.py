def solution(a, b):
    date={'0':'FRI','1':'SAT','2':'SUN','3':'MON','4':'TUE','5':'WED','6':'THU'}
    m=[31,29,31,30,31,30,31,31,30,31,30,31]
    diff=b-1
    for idx in range(a-1):
        diff += m[idx]
    return date[str(diff%7)]
