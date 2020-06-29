package me.bingyue.test;

import java.util.*;

class Solution {
//    public int[] topKFrequent(int[] nums, int k) {
//        List<Integer>[] bucket = new List[nums.length + 1];
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int n : nums) {
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
//
//        for (int key : map.keySet()) {
//            int frequency = map.get(key);
//            if (bucket[frequency] == null) {
//                bucket[frequency] = new ArrayList<>();
//            }
//            bucket[frequency].add(key);
//        }
//
//        List<Integer> res = new ArrayList<Integer>();
//
//        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
//            if (bucket[pos] != null) {
//                res.addAll(bucket[pos]);
//            }
//        }
//        return  res.stream().toArray(Integer[]::new);
//    }

    class TrieNode {
        // 存储最后节点的字符串
        String val;
        // 结尾标记
        boolean isEnd;
        // 每个节点最多有26个不同的小写字母
        // 这里用数组表示
        TrieNode[] next;
        public TrieNode() {
            isEnd = false;
            //注意设置容量
            next = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root = new TrieNode();
        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                //注意是减去'a'，这里的next实质也是当字典来用
                int ch = word.charAt(i) - 'a';
                if (cur.next[ch] == null) {
                    cur.next[ch] = new TrieNode();
                }
                //注意是去trieNode数组里找
                cur = cur.next[ch];
            }
            // 设置标记，表示为一个单词
            cur.isEnd = true;
            cur.val = word;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        TrieNode root = trie.root;

        //插入数据
        for (String word : words) {
            trie.insert(word);
        }

        //构建结果集容器
        List<String> res = new LinkedList<>();

        //矩阵行数
        int m = board.length;
        //矩阵列数
        int n = board[0].length;
        //存储该节点是否访问
        boolean[][] visited = new boolean[n][m];

        //遍历整个二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, m, n, res, root);
            }
        }
        return res;
    }


    /**
     * 这道题目就是在dfs的过程中，添加了一个trie树的剪枝，然后把符合要求的返回到结果中
     */
    private void dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n, List<String> result, TrieNode cur) {
        //边界判断以及是否已经访问判断
        if (i < 0 || i >= m || j < 0 || j >= n || visited[j][i])
            return;
        //获取子节点状态，判断其是否有子节点
        cur = cur.next[board[i][j] - 'a'];
        if (cur == null) {
            return;
        }

        //修改节点状态，防止重复访问
        visited[j][i] = true;

        //找到单词加入
        if (cur.isEnd) {
            result.add(cur.val);
            //找到单词后，修改字典树内叶子节点状态为false，防止出现重复单词
            cur.isEnd = false;
        }

        // 搜索四个方向
        dfs(board, visited, i + 1, j, m, n, result, cur);
        dfs(board, visited, i - 1, j, m, n, result, cur);
        dfs(board, visited, i, j + 1, m, n, result, cur);
        dfs(board, visited, i, j - 1, m, n, result, cur);
        //最后修改节点状态为未访问状态
        visited[j][i] = false;
    }
}