numbers = list(map(int,input()))
hand = input()

def solution(numbers, hand):
    answer = ''
    arr = [[0 for col in range(3)] for row in range(4)]
    left = [1,4,7]
    left_pos = [(0,0),(1,0),(2,0)]
    right = [3,6,9]
    right_pos = [(0,2),(1,2),(2,2)]
    middle = [2,5,8,0]
    middle_pos = [(0,1),(1,1),(2,1),(3,1)]

    point = [[3,0],[3,2]]
    for i in range(len(numbers)):
        if numbers[i] in left:
            point[0] = left_pos[left.index(numbers[i])]
            answer+='L'
        elif numbers[i] in right:
            point[1] = right_pos[right.index(numbers[i])]
            answer+='R'
        elif numbers[i] in middle:
            o_point = middle_pos[middle.index(numbers[i])]
            left_distance = abs(point[0][0]-o_point[0]) + abs(point[0][1]-o_point[1])
            right_distance = abs(point[1][0]-o_point[0]) + abs(point[1][1]-o_point[1])
            if(left_distance<right_distance):
                point[0] = o_point
                answer+='L'
            elif(left_distance>right_distance):
                point[1] = o_point
                answer+='R'
            elif(left_distance == right_distance):
                if(hand == 'left'):
                    point[0] = o_point
                    answer+='L'
                else:
                    point[1] = o_point
                    answer+='R'
    
    return answer

result = solution(numbers, hand)
print(result)

