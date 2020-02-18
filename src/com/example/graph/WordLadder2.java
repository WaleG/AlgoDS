package com.example.graph;

public class WordLadder2 {
//    public static void main(String[] args) {
//        String beginWord = "hit";
//        String endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        List<List<String>> result = new WordLadder2().findLadders(beginWord, endWord, wordList);
//        result.forEach(System.out::println);
//    }
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Queue<String> q = new LinkedList<>();
//        Set<String> notVisited = new HashSet<>(wordList);
//        q.add(beginWord);
//        List<List<String>> result = new ArrayList<>();
//        bfs(q, beginWord, endWord, notVisited, new ArrayList<Integer>(), result);
//        return result;
//    }
//
//    private void bfs(Queue<String> q,
//                     String beginWord,
//                     String endWord,
//                     Set<String> notVisited,
//                     List<Integer> current,
//                     List<List<String>> result) {
//        while (!q.isEmpty())
//    }
//
//    private boolean isTransformation(String word, String candidate) {
//        int count = 0;
//        for (int i = 0; i < word.length(); i++) {
//            if (word.charAt(i) != candidate.charAt(i)) {
//                count++;
//            }
//            if (count > 1) {
//                return false;
//            }
//        }
//        return count == 1;
//    }
}
