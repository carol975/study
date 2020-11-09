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
    
# arr = [62,26,63,27,20,21,80]
arr = [0, 0, 2, 2, 62, 6, 7]
radix_sort(arr)
print(arr)