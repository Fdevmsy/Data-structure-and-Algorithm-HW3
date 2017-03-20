user: 011551358 (Shiyu, Mou)

1. To achieve O(nlogn), it becomes a quick sort problem. However, we cannot compare within nuts or bolts. So we should use element in nuts as pivoit and partition bolts, and use the pivoit we got in bolts to partition nuts. T(n) = 2T(n/2) + O(n). a = 2, b = 2. n^logb(a) = n. So T(n) = Θ(n^1 logn) = Θ(nlogn).

2. Dequeue the max in a binary heap gives O(lgN) compares(T(n) = T(n/2) + f(n)). So for k times, it results in O(klogn).

3. We can just do a binary search. We recursively look at A[n/2 − 1],A[n/2],A[n/2 + 1] to see if it's on a upslope, downslop or on the peak. So T(n) < = T(n/2) + 3. a = 1, b = 2. f(n) = O(1), n^logb(a) = n^0 = O(1). So T(n) = Θ(n^0logn) = Θ(logn).