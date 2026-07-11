public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    public static void dfs(int[][] graph, boolean[] visited, int city) {
        visited[city] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[city][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int result = findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + result);
    }
}