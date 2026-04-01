package com.starlink.backend.dsa.stack;

import java.util.*;
//https://leetcode.com/problems/robot-collisions/description/?envType=daily-question&envId=2026-04-01
public class RobotCollision {

    public List<Integer> survivedRobotsHealths(
            int[] positions, int[] healths, String directions) {

        int n = positions.length;

        // Step 1: Index array banao, position se sort karo
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);

        // Step 2: Stack — R wale robots track karo
        // Stack mein original index store karo
        Deque<Integer> stack = new ArrayDeque<>();

        // Step 3: Process karo position order mein
        for (int i : idx) {
            if (directions.charAt(i) == 'R') {
                // R → stack mein daalo
                stack.push(i);

            } else {
                // L → stack se ladao
                boolean alive = true;

                while (!stack.isEmpty() && alive) {
                    int top = stack.peek();

                    if (healths[top] > healths[i]) {
                        // R jeet gaya
                        healths[top]--;
                        alive = false; // L mar gaya

                    } else if (healths[top] < healths[i]) {
                        // L jeet gaya
                        healths[i]--;
                        // stack.pop(); // R mar gaya
                        healths[stack.pop()] = 0;

                    } else {
                        // dono mar gaye
                        // stack.pop();
                        healths[stack.pop()] = 0;
                        alive = false;
                    }
                }

                // L bacha → koi R nahi tha stack mein
                if (!alive) healths[i] = 0; // mark as dead
            }
        }

        // Step 4: Original order mein survivors nikalo
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] != 0) {
                result.add(healths[i]);
            }
        }

        return result;
    }
}
// ```

// ---

// ## Dead Robot Mark Kyun Kiya 0 Se?
// ```
// healths[i] = 0  → robot mar gaya

// Original order mein traverse karte waqt:
// healths[i] != 0 → survivor hai → result mein daalo
// healths[i] == 0 → dead hai → skip karo
// ```

// ---

// ## Summary — Pattern
// ```
// ┌─────────────────────────────────────┐
// │ STACK COLLISION PATTERN             │
// ├─────────────────────────────────────┤
// │ 1. Position se sort karo            │
// │                                     │
// │ 2. R → stack mein push karo         │
// │                                     │
// │ 3. L → stack top se ladao           │
// │    R > L → R--, L dies             │
// │    R < L → L--, R dies (pop)       │
// │    R == L → dono die (pop)         │
// │                                     │
// │ 4. Stack khaali → L survive karta  │
// │                                     │
// │ 5. Original order mein result do   │
// └─────────────────────────────────────┘

// Same problems:
// → Asteroid Collision (bilkul same!)
// → Next Greater Element
// → Buildings With Ocean View