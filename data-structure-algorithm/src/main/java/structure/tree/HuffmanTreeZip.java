package structure.tree;

import leetcode.base.definition.TreeNode;
import org.junit.Test;

import java.util.*;

public class HuffmanTreeZip {

    public List<TreeNode> getNodesFromBytes(byte[] bytes) {
        List<TreeNode> list = new ArrayList<>();
        Map<Byte, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < bytes.length; i++) {
            byte key = bytes[i];
            charCountMap.putIfAbsent(key, 0);
            Integer integer = charCountMap.get(key);
            charCountMap.put(key, integer + 1);
        }
        for (Map.Entry<Byte, Integer> entry : charCountMap.entrySet()) {
            TreeNode treeNode = new TreeNode();
            treeNode.setVal((int) entry.getKey());
            treeNode.setWeight(entry.getValue());
            list.add(treeNode);
        }
        return list;
    }

    public List<TreeNode> getNodesFromString(String content) {
        List<TreeNode> list = new ArrayList<>();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
            char key = content.charAt(i);
            charCountMap.putIfAbsent(key, 0);
            Integer integer = charCountMap.get(key);
            charCountMap.put(key, integer + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            TreeNode treeNode = new TreeNode();
            treeNode.setVal((int) entry.getKey());
            treeNode.setWeight(entry.getValue());
            list.add(treeNode);
        }
        return list;
    }


    public TreeNode build(List<TreeNode> nodeList) {

        //先要排序
        nodeList.sort(Comparator.comparingInt(o -> o.weight));
        while (nodeList.size() >= 2) {
            TreeNode a = nodeList.remove(0);
            TreeNode b = nodeList.remove(0);
            TreeNode newNode = new TreeNode();
            newNode.left = a;
            newNode.right = b;
            newNode.weight = a.weight + b.weight;
            int i = 0;
            //找到合适的位置，插入新的节点
            while (i < nodeList.size() && newNode.getWeight() > nodeList.get(i).getWeight()) i++;
            nodeList.add(i, newNode);
        }
        return nodeList.remove(0);
    }

    public void getHuffmanCode(TreeNode root, StringBuilder codeString, Map<Byte, String> codeMap) {
        if (root.val != null) {
            codeMap.put((byte) (int) root.val, codeString.toString());
            return;
        }
        getHuffmanCode(root.left, new StringBuilder(codeString).append('0'), codeMap);
        getHuffmanCode(root.right, new StringBuilder(codeString).append('1'), codeMap);
    }

    @Test
    public void testByte() {
    }

    public byte[] zip(byte[] input, Map<Byte, String> huffmanCode) {
        List<TreeNode> nodesFromBytes = getNodesFromBytes(input);
        TreeNode build = build(nodesFromBytes);
        getHuffmanCode(build, new StringBuilder(), huffmanCode);
        StringBuilder outputString = new StringBuilder();
        for (byte b : input) {
            outputString.append(huffmanCode.get(b));
        }
        int byteLen = (outputString.length() + 7) / 8;
        byte[] bytes = new byte[byteLen];
        String s = outputString.toString();
        System.out.println("before zip string：");
        System.out.println(s);
        for (int i = 0; i < s.length(); i += 8) {
            int i1;
            if (i + 8 < s.length()) {
                i1 = Integer.parseInt(s.substring(i, i + 8), 2);
            } else {
                i1 = Integer.parseInt(s.substring(i), 2);
            }
            bytes[i / 8] = (byte) i1;
        }
        return bytes;
    }


    @Test
    public void test() {

    }

    //这个压缩方法还需要处理最后一个byte，因为不足8位。
//    另外，在压缩的时候，可以写入
//    1.bytes数组
//    2.Map<Byte, String> huffmanCode
//    3.最后一个byte的补0个数

    @Test
    public void testZip() {
        byte[] bytes = "i like like like java do you like a java".getBytes();
        System.out.println("---bytes len---------------->" + bytes.length);
        Map<Byte, String> huffmanCode = new HashMap<>();
        byte[] zip = zip(bytes, huffmanCode);
        System.out.println("-----------zip len---------------->" + zip.length);

        String result = "";
        for (int i = 0; i < zip.length; i++) {
            result += String.format("%8s", Integer.toBinaryString(zip[i] & 0xFF)).replace(' ', '0');
//            result += Integer.toBinaryString(zip[i] & 0xFF);
        }
        System.out.println("unzipString:---------->");
        System.out.println(result);

        StringBuilder unzipStr = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
                if (result.startsWith(entry.getValue(), i)) {
                    char key = (char) (byte) entry.getKey();
                    System.out.println("匹配了，" + key);
                    unzipStr.append(key);
                    i += entry.getValue().length() - 1;
                    break;
                }
            }
        }
        displayHuffmanCodeMap(huffmanCode);
        System.out.println(unzipStr.toString());
    }

    public void displayHuffmanCodeMap(Map<Byte, String> map) {
        for (Map.Entry<Byte, String> entry : map.entrySet()) {
            System.out.println((char) ((int) entry.getKey()) + "," + entry.getValue());
        }
    }

    @Test
    public void testGetNodes() {
        List<TreeNode> nodesFromString = getNodesFromString("i like like like java do you like a java");
        for (TreeNode treeNode : nodesFromString) {
            System.out.println((char) (int) treeNode.val + "," + treeNode.weight);
        }
        TreeNode build = build(nodesFromString);
        System.out.println("build结束");
        TraverseTreeRecursion traverseTreeRecursion = new TraverseTreeRecursion();
        traverseTreeRecursion.preOrder(build);
        HashMap<Byte, String> codeMap = new HashMap<>();
        getHuffmanCode(build, new StringBuilder(), codeMap);
        for (Map.Entry<Byte, String> entry : codeMap.entrySet()) {
            System.out.println((char) ((int) entry.getKey()) + "," + entry.getValue());
        }
    }
}
