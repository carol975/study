import math
from random import randint
def counting_sort(arr, digit_pos):
    # O(n+k)
    count = [0] * 10
    arr_sorted = [0] * len(arr)

    # O(n)
    for num in arr: 
        index = num // digit_pos % 10
        count[index] += 1
    
    # O(k), k = 10 in decimal system
    for i in range(1,len(count)):
        count[i] += count[i-1]
    
    # O(n)
    for i in range(len(arr)-1, -1, -1):
        num = arr[i]
        index = num // digit_pos % 10
        pos = count[index] - 1 # arr_sorted index starts at 0, count[index] starts at 1
        arr_sorted[pos] = num
        count[index] -= 1
    print(arr_sorted)
    arr[:] = arr_sorted

def radix_sort(arr):
    max_num = max(arr)

    digit_pos = 1

    while max_num // digit_pos > 0: 
        # O(d(n+k)), d = total digit_pos change 
        counting_sort(arr, digit_pos)
        digit_pos *= 10

def selection_sort(arr): 
    # best O(n), worst O(n^2)
    for j in range(1, len(arr)):
        i = j - 1
        while arr[i] > arr[j] and i >= 0:
            i-=1
        i += 1
        arr[j], arr[i] = arr[i], arr[j]

def bucket_sort(arr, k):
    # avg O(n), worst: O(n^2)
    m = max(arr)
    buckets = []
    for _ in range(k):
        buckets.append([])
    
    for num in arr:
        index = math.floor(num / m * k)
        if index == k:
            index -= 1
        buckets[index].append(num)
    
    for b in buckets:
        selection_sort(b)
    
    result = []
    for b in buckets:
        result.extend(b)
    
    return result

def rand_quick_sort(arr, p, r):
    # best O(nlgn), worst O(n^2)
    # depends on the partition point i
    if p < r:
        rand_ind = randint(p, r)
        arr[rand_ind], arr[r] = arr[r], arr[rand_ind]
        i = p-1
        j = p
        while j < r:
            if arr[j] <= arr[r]:
                i+=1 
                arr[i], arr[j] = arr[j], arr[i]
            j+=1

        i+=1
        arr[i], arr[r] = arr[r], arr[i]

        rand_quick_sort(arr, p, i-1)
        rand_quick_sort(arr, i+1, r)
            

# arr = [62,26,63,27,20,21,80]
# arr = [0, 0, 2, 2, 62, 6, 7]
# radix_sort(arr)
# print(arr)

arr = [0.62,0.26,0.63,0.27,0.20,0.21,-0.80]

# sorted_arr = bucket_sort(arr, len(arr))
rand_quick_sort(arr, 0, len(arr)-1)
print(arr)