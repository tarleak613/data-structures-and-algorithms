# 📝 Geek's Training (GeeksforGeeks)

🔗 [Problem Link](https://www.geeksforgeeks.org/problems/geeks-training/1)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-orange) ![Language](https://img.shields.io/badge/Language-Java-blue)

### 💡 Tags
Dynamic Programming, Arrays

### 🚀 Performance
- **Runtime:** Successfully Evaluated
- **Memory:** N/A

---

### 📜 Problem Description

Geek is attending a training program for n **** days. Each day he must perform exactly one of three activities: Running, Fighting, or Learning. Each activity earns a certain number of merit points, which can differ from day to day. 
To improve all his skills, Geek cannot perform the same activity on two consecutive days.
Given a 2D matrix  **mat[][]** , where for the i-th day:

- mat[i][0] is the merit points for Running
- mat[i][1] is the merit points for Fighting
- mat[i][2] is the merit points for Learning

Return the maximum total merit points Geek can earn over the n days.

**Example:**

```
Input: mat[][] = [[8, 7, 1], [9, 2, 1]]
Output: 16
Explanation: Picking the best activity on day 1 (Running, 8) blocks Running on day 2,
so the best he could then get is Fighting (2), giving 10.
Instead, Geek does Fighting on day 1 (7) and Running on day 2 (9), giving 7 + 9 = 16.
```

```
Input: mat[][] = [[2, 5, 3], [6, 4, 1], [3, 7, 2], [4, 4, 9]]
Output: 27
Explanation: One optimal plan is Fighting (5), Running (6), Fighting (7), Learning (9).
No activity repeats on consecutive days, and the total is 5 + 6 + 7 + 9 = 27.
```

```
Input: mat[][]= [[4, 2, 6]]
Output: 6
Explanation: With only one day there is no consecutive-day restriction, so Geek simply picks the best activity, Learning, and earns 6 points.
```