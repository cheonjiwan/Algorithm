from functools import cmp_to_key

numbers=[3, 30, 34, 5, 9]
def compare_func(a,b):
    ab=int(a+b)
    ba=int(b+a)

    if ab<ba: return -1
    elif ab>ba: return 1
    else: return 0

def solution(numbers):
    answer=' '
    numbers=list(map(str,numbers))
    numbers=sorted(numbers,key=cmp_to_key(compare_func),reverse=True)
    answer = str(int(''.join(numbers)))

    return answer

print(solution(numbers))