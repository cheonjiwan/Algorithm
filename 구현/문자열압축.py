import sys

input = sys.stdin.readline

s = "ababcdcdababcdcd"


def solution(s):
    answer = len(s)

    for i in range(1, len(s) // 2 + 1):
        mystr = ""
        prev = s[:i]
        count = 1
        for j in range(i, len(s), i):
            if prev == s[j : j + i]:
                count += 1
            else:
                mystr += str(count) + prev if count >= 2 else prev
                prev = s[j : j + i]
                count = 1
        mystr += str(count) + prev if count >= 2 else prev
        answer = min(answer, len(mystr))

    return answer


print(solution(s))