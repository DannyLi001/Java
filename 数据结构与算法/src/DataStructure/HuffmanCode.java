package DataStructure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanZip = huffmanZip(contentBytes);

        byte[] sourceBytes = decode(huffmanCodes, huffmanZip);
        System.out.println(new String(sourceBytes));
    }

    public static void unzipFile(String zipFile, String dstFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(zipFile);
            ois = new ObjectInputStream(fis);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            fos = new FileOutputStream(dstFile);
            fos.write(bytes);

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                fos.close();
                ois.close();
                fis.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void zipFile(String srcFile, String dstFile) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // 创建文件输入流
            fis = new FileInputStream(srcFile);
            // 创建一个和源文件大小一样的byte[]
            byte[] b = new byte[fis.available()];
            // 读取文件
            fis.read(b);
            // 对文件压缩
            byte[] huffmanBytes = huffmanZip(b);
            // 创建文件输出流，存放压缩文件
            fos = new FileOutputStream(dstFile);
            // 使用ObjectOutputStream输出
            oos = new ObjectOutputStream(fos);
            oos.writeObject(huffmanBytes);
            // 存放赫夫曼编码表
            oos.writeObject(huffmanCodes);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                fis.close();
                fos.close();
                oos.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    /**
     * 对压缩文件解码
     * 
     * @param huffmanCodes 赫夫曼编码表
     * @param huffmanBytes 赫夫曼编码字节数组
     * @return 原来的字符串对应数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            stringBuilder.append(byteToBitString(i != huffmanBytes.length - 1, huffmanBytes[i]));
        }
        // 编码表转解码表
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 把字符串按照赫夫曼解码表进行解码
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    /**
     * 将一个byte转成一个二进制的字符串
     * 
     * @param flag 表示是否需要补高位，最后字节无需补高位
     * @param b    传入的byte
     * @return 对应的二进制字符串（补码形式）
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            // 按位与256 1 0000 0000 | 0000 0001 => 1 0000 0001
            temp |= 256;
        }
        // 返回的是temp对应的二进制的补码 4bytes 16bits
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 使用一个方法，将前面的方法封装
     * 
     * @param bytes 原始的字符串对应的字节数组
     * @return 经过赫夫曼编码处理后的字节数组
     */
    private static byte[] huffmanZip(byte[] bytes) {
        // 给每个字节创建节点
        List<Node1> Node1s = getNode1s(bytes);
        // 创建赫夫曼树
        Node1 head = createHuffmanTree(Node1s);
        // 赫夫曼编码表
        Map<Byte, String> huffmanCodes = getCodes(head);
        // 生成赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] zip = zip(bytes, huffmanCodes);
        return zip;
    }

    // 将字符转成节点并进行统计
    private static List<Node1> getNode1s(byte[] bytes) {
        ArrayList<Node1> Node1s = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, ++count);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            Node1s.add(new Node1(entry.getKey(), entry.getValue()));
        }
        return Node1s;
    }

    // 用所有节点生成一个赫夫曼树
    private static Node1 createHuffmanTree(List<Node1> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node1 left = nodes.get(0);
            Node1 right = nodes.get(1);

            Node1 parent = new Node1(null, right.weight + left.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static void preOrder(Node1 root) {
        if (root == null) {
            System.out.println("isEmpty");
        } else {
            root.preOrder();
        }
    }

    // 对字符进行编码
    static StringBuilder stringBuilder = new StringBuilder();
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    private static Map<Byte, String> getCodes(Node1 root) {
        if (root == null) {
            return null;
        }
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入huffmanCodes集合
     * 
     * @param node          节点
     * @param code          路径：左子节点0，右子节点1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node1 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder2);
                getCodes(node.right, "1", stringBuilder2);
            } else {
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

    /**
     * 将字符串对应的byte[]数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
     * 
     * @param bytes        原始字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        // 利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        // 将stringBuilder转成byte[]
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        // 创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmanCodeBytes;
    }

}

class Node1 implements Comparable<Node1> {
    Byte data;
    int weight;
    Node1 left;
    Node1 right;

    public Node1(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node1 o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return data == null ? "Node1 [data=" + data + ", weight=" + weight + "]"
                : "Node1 [data=" + (char) (byte) data + ", weight=" + weight + "]";
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}