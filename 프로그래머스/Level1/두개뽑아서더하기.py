def solution(numbers):
    answer = set()
    for i in range(len(numbers)):
        for j in range(i+1,len(numbers)):
            answer.add(numbers[i]+numbers[j])
    answer=list(answer)
    answer.sort()
    return answer

numbers=[5,0,2,7]
print(solution(numbers))