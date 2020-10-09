from bisect import bisect_left,bisect_right

words = ["frodo", "front", "frost", "frozen", "frame", "kakao"]
queries = ["fro??", "????o", "fr???", "fro???", "pro?"]

array = [[] for _ in range(10001)]
reversed_array = [[] for _ in range(10001)]

def count_by_range(a, left, right):
    right_index = bisect_right(a, right)
    left_index = bisect_left(a, left)

    return right_index - left_index
    
def solution(words, queries):
    answer = []

    for word in words:
        array[len(word)].append(word)
        reversed_array[len(word)].append(word[::-1])
    
    for i in range(10001):
        array[i].sort()
        reversed_array[i].sort()
    
    for query in queries:
        if query[0] != '?': # ?는 뒤에
            result = count_by_range(array[len(query)],query.replace('?', 'a'),query.replace('?', 'z'))
        else: # ?는 앞에
            query = query[::-1]
            result = count_by_range(reversed_array[len(query)],query.replace('?', 'a'),query.replace('?', 'z'))
        answer.append(result)        
    return answer

print(solution(words,queries))