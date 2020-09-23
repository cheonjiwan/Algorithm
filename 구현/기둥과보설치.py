n = 5
build_frame = [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
#board = [[0]*(n) for _ in range(n)]

def solution(n, build_frame):
    answer = []
    flag=True
    for item in build_frame:
        # x,y, a=0 기둥, a=1 보 / b=0 삭제, b=1 설치
        where_x,where_y,what,how = item
        if how==0: # 제거
            answer.remove([where_x,where_y,what])
            # check
            for x,y,a in answer:
                if a==0:
                    if y==0 or [x,y-1,0] in answer or [x-1,y,1] in answer or [x,y,1] in answer:
                        continue
                    else:
                        flag=False
                else:
                    if [x,y-1,0] in answer or [x+1,y-1,0] in answer or ([x-1,y,1] in answer and [x+1,y,1] in answer):
                        continue
                    else:
                        flag=False
            if flag==False:
                answer.append([where_x,where_y,what])
                flag=True
        else: # 설치
            answer.append([where_x,where_y,what])
            # check
            for x,y,a in answer:
                if a==0:
                    if y==0 or [x,y-1,0] in answer or [x-1,y,1] in answer or [x,y,1] in answer:
                        continue
                    else:
                        flag=False
                else:
                    if [x,y-1,0] in answer or [x+1,y-1,0] in answer or ([x-1,y,1] in answer and [x+1,y,1] in answer):
                        continue
                    else:
                        flag=False
            if flag==False:
                answer.remove([where_x,where_y,what])
                flag=True
        
        
    return sorted(answer)

print(solution(n,build_frame))