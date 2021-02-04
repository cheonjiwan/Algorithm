from collections import deque
from copy import deepcopy
import sys
input=sys.stdin.readline

def init():
    cnt=1
    arr=[];tmp=[]
    while True:
        data=list(map(int,input().rstrip().split()))
        if data:
            if data[0]==-1 and data[1]==-1: 
                break
            if data[-1]==0 and data[-2]==0:
                tmp.extend(data[:-2])
                arr.append(tmp)
                tmp=[]
            else: tmp.extend(data)

    return cnt,arr

cnt,cases=init()
k=1
for case in cases:
    if len(case)==0: print('Case {} is a tree.'.format(k));k+=1;continue
    maxV=max(case)
    minV=min(case)
    indegree=[0]*(maxV+1)
    outdegree=[0]*(maxV+1)
    node=[False]*(maxV+1)
    edgeCnt=0
    graph=[[] for _ in range(maxV+1)]
    for i in range(0,len(case)-1,2):
        a,b=case[i],case[i+1]
        graph[a].append(b)
        indegree[b]+=1
        outdegree[a]+=1
        node[a]=True;node[b]=True
        edgeCnt+=1

    nodeCnt=node.count(True)
    
    rootCnt=0;otherCnt=0;treeFlag=True
    rootNode=0;
    for i in range(1,maxV+1):
        if node[i]:
            if indegree[i]==0: rootCnt+=1;rootNode=i
            if indegree[i]==1: otherCnt+=1
    
    if otherCnt!=edgeCnt: treeFlag=False
    if rootCnt>1: treeFlag=False
    else:
        node2Flag=True
        node2=deepcopy(node)
        q=deque();q.append(rootNode)
        visited=[False]*(maxV+1)
        visited[rootNode]=True
        component=1
        while q:
            now=q.popleft()
            for nextNode in graph[now]:
                component+=1
                if nextNode==rootNode:
                    node2Flag=False
                    break
                if visited[nextNode]:
                    node2Flag=False
                    break
                else:
                    visited[nextNode]=True
                    q.append(nextNode)
            if not node2Flag: break

        if component!=nodeCnt: node2Flag=False
    if treeFlag and nodeCnt-1==edgeCnt and node2Flag :
        print('Case {} is a tree.'.format(k))
    else:
        print('Case {} is not a tree.'.format(k))
    k+=1

