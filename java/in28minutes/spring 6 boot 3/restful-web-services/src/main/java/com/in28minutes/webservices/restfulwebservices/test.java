package com.in28minutes.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class test {

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution2 {
    class Info {
        TreeNode node;
        int col;
        int row;

        Info(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    private void traverse(TreeNode cur, PriorityQueue<Info> pq, int col, int row) {
        if (cur == null)
            return;
        pq.offer(new Info(cur, col, row));
        traverse(cur.left, pq, col - 1, row + 1);
        traverse(cur.right, pq, col + 1, row + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        PriorityQueue<Info> pq = new PriorityQueue<>(
                (a, b) -> a.col != b.col ? a.col - b.col : a.row != b.row ? a.row - b.row : a.node.data - b.node.data);
        traverse(root, pq, 0, 0);
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            Info cur = pq.poll();
            tmp.add(cur.node.data);
            int curCol = cur.col;
            while (!pq.isEmpty() && pq.peek().col == curCol) {
                tmp.add(pq.poll().node.data);
            }
            res.add(tmp);
        }
        return res;
    }

}

class Solution1 {
    record Info(TreeNode node, int row, int col) {
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        Collections.sort(infoList, (Info a, Info b) -> {
            if (a.col == b.col) {
                if (a.row == b.row)
                    return a.node.data - b.node.data;
                else
                    return a.row - b.row;
            } else
                return a.col - b.col;
        });
        List<List<Integer>> result = new LinkedList<>();
        int preCol = Integer.MIN_VALUE;
        for (int i = 0; i < infoList.size(); i++) {
            Info cur = infoList.get(i);
            if (cur.col > preCol) {
                result.add(new LinkedList<>());
                preCol = cur.col;
            }
            result.get(result.size() - 1).add(cur.node.data);
        }
        return result;
    }

    ArrayList<Info> infoList = new ArrayList<>();

    private void traverse(TreeNode root, int row, int col) {
        if (root == null)
            return;
        infoList.add(new Info(root, row, col));
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return new MyList(root);
    }

    static class MyList extends ArrayList<List<Integer>> {
        TreeNode root;

        public MyList(TreeNode treeNode) {
            this.root = treeNode;
        }

        public int size() {
            method();
            return super.size();
        }

        private void method() {
            if (root == null)
                return;
            HashMap<Integer, List<Info>> map = new HashMap<>();
            int minCol = method(root, map, 0, 0);
            int size = map.size() + minCol;
            List<List<Integer>> list = this;
            while (minCol < size) {
                List<Info> infos = map.get(minCol++);
                List<Integer> subRes = new ArrayList<>();
                list.add(subRes);
                infos.sort(Info::compareTo);
                for (Info i : infos)
                    subRes.add(i.data);
            }
            root = null;
        }

        public int method(TreeNode node, HashMap<Integer, List<Info>> map, int row, int col) {
            if (node == null)
                return 0;
            if (map.containsKey(col))
                map.get(col).add(new Info(row, node.data));
            else {
                ArrayList<Info> list = new ArrayList<>();
                list.add(new Info(row, node.data));
                map.put(col, list);
            }
            return Math.min(Math.min(method(node.left, map, row - 1, col - 1), col),
                    method(node.right, map, row - 1, col + 1));
        }
    }

    static class Info implements Comparable<Info> {
        private final int row;
        public final int data;

        public int compareTo(Info that) {
            return this.row == that.row ? this.data - that.data : that.row - this.row;
        }

        public Info(int row, int val) {
            this.row = row;
            this.data = val;
        }
    }
}