package spring.demo.test;

import lombok.Data;

import java.util.List;

/**
 * @Package: spring.demo.test
 * @ClassName: LinkedListCreator
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/12/2 14:48
 * @UpdateDate: 2019/12/2 14:48
 */
@Data
public class LinkedListCreator {
    //构建函数
    public Node createLinkedList(List<Integer> list){
        if (list.isEmpty()){
            return null;
        }
        Node headNode = new Node(list.get(0));
        Node tempNode = createLinkedList(list.subList(1, list.size()));
        headNode.setNode(tempNode);
        return headNode;
    }

    //测试方便的打印函数
    public void printList(Node node){
        while (node != null){
            System.out.print(node.getValue());
            System.out.print(" ");
            node = node.getNode();
        }
        System.out.println();
    }
}
