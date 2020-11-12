'''
a selection algorithm is an algorithm for 
finding the kth smallest number in a list or array; 
such a number is called the kth order statistic. 
This includes the cases of finding the minimum, 
maximum, and median elements.
'''
from random import randint
def rand_partition(arr, p, r):
    
    rand_ind = randint(p,r)
    
    # swap last ele with ele at rand_ind
    arr[r], arr[rand_ind] = arr[rand_ind], arr[r]

    i = p-1
    
    for j in range(p, r):
        if arr[j] <= arr[r]:
            i+=1
            arr[j], arr[i] = arr[i], arr[j]
    i+=1
    arr[r], arr[i] = arr[i], arr[r]
    return i

def selection(arr, k, p, r):
    # avg O(n)
    if p == r:
        return arr[p]

    i = rand_partition(arr, p, r)
    if i == k:
        return arr[i]
    elif i < k:
        return selection(arr, k, i+1, r)
    else:
        return selection(arr, k, p, i-1)


arr = [0.62,0.26,0.63,0.27,0.20,0.21,-0.80]
k = randint(0,len(arr)-1)
val = selection(arr, k, 0, len(arr)-1)  

assert(val == sorted(arr)[k])
