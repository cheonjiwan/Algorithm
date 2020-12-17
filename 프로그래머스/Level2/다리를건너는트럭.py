bridge_length = 2
weight = 10
truck_weights = [7,4,5,6]

class truck:
    def __init__(self,loc,weight):
        self.loc = loc
        self.weight = weight

def goOneStep(bridge_list, bridge_length):
    minus = 0
    deleteFlag = False

    for value in bridge_list:
        trObject = value
        trObject.loc +=1 
        if trObject.loc > bridge_length:
            deleteFlag = True
            minus = trObject.weight

    if deleteFlag:
        del(bridge_list[0])
    
    return minus    

def checkGoBridge(curWeight, trObject, weight):
    if trObject.weight +curWeight > weight:
        return True
    return False

def solution(bridge_length, weight, truck_weights):
    answer = 0
    curWeight = 0
    bridge_list = []
    
    for value in truck_weights:
        trObject = truck(1, value)
        checkResult = True
        
        while checkResult:
            curWeight -= goOneStep(bridge_list, bridge_length)
            checkResult = checkGoBridge(curWeight, trObject, weight)
            answer+=1

        bridge_list.append(trObject)
        curWeight += trObject.weight

    answer += bridge_length
    return answer

print(solution(bridge_length,weight,truck_weights))