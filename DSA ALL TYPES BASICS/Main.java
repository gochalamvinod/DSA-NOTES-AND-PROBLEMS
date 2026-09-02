/*
TYPES OF TWO POINTERS
--------------------------

1. OPPOSITE ENDS
   - Converging: both move inward toward each other
   - One fixed, one moving: fix one end, move the other

2. SAME DIRECTION
   - Fixed speed gap: slow+1, fast+k (constant gap)
   - Variable speed: fast moves 2x, 3x slower's speed

3. SLIDING WINDOW
   - Fixed size: window size stays constant
   - Variable size (shrink on violation): expand right, shrink left when invalid
   - Variable size (expand until condition): grow until condition satisfied

4. MERGE STYLE
   - Two separate arrays: one pointer per array, advance smaller
   - Same array in-place: merge from end to avoid overwriting

5. PARTITION
   - Single pivot: one boundary pointer, one scan pointer
   - Two pivot: two boundary pointers, one scan pointer
   - Three-way (Dutch flag): lo, mid, hi — three regions

6. LINKEDLIST CYCLE (FLOYD'S)
   - Cycle detection only: slow+1, fast+2 — meet inside cycle
   - Cycle + entry point: after meeting, reset one to head, both move +1
   - Duplicate in array: treat array as linked list, same logic

*/

