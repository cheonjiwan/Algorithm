def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        tmp=[];flag=True
        for c in skill_tree:
            if c in skill:
                tmp.append(c)
        for i in range(len(tmp)):
            if skill[i]!=tmp[i]: flag=False; break
        if flag: answer+=1
    
    return answer

skill="CBD"
skill_trees=["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill,skill_trees))