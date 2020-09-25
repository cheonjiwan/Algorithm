p = "()))((()"


def parse(p):
    u = ""
    v = ""
    count1 = 0
    count2 = 0
    for c in p:
        if c == "(":
            u += c
            count1 += 1
        else:
            u += c
            count2 += 1
        if count1 == count2:
            break
    v = p[count1 + count2 :]
    return u, v


def check(u):
    count = 0
    for c in u:
        if c == "(":
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    return True


def solution(p):
    answer = ""
    if p == "":
        return answer
    u, v = parse(p)
    if check(u):
        answer = u + solution(v)
    else:
        answer += "("
        answer += solution(v)
        answer += ")"
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == "(":
                u[i] = ")"
            else:
                u[i] = "("
        answer += "".join(u)
    return answer


print(solution(p))