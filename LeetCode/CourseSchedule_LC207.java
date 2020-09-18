import java.util.*;

/**
 * Process the input to store mappings of (course prereq of)->(courses) and how many prereqs should be taken for a particular course
 * Use a queue and keep taking courses that have 0 prereqs and see if we can cover all courses leading to completion of all courses
 * resulting into 0 inDegrees for whole set of courses
 * Time Complexity: O(V + E): V: number of courses, E: Prereqs
 * Space Complexity: O(V + E)
 */
public class CourseSchedule_LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];                      // Number of dependencies for each course
        Map<Integer, List<Integer>> adjList = new HashMap<>();      // Parent-Children per course

        // Form initial adjacency list and in degrees per course
        for (int[] dependency : prerequisites) {
            inDegrees[dependency[0]]++;
            if (!adjList.containsKey(dependency[1]))
                adjList.put(dependency[1], new ArrayList<>());
            adjList.get(dependency[1]).add(dependency[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegrees[i] == 0)              // Courses with 0 inDegrees don't depend on others so add them
                queue.offer(i);

        int count = 0;
        while (!queue.isEmpty()) {
            int subject = queue.poll();
            if (adjList.containsKey(subject)) {
                for (int child : adjList.get(subject)) {
                    if (--inDegrees[child] == 0)
                        queue.offer(child);
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
