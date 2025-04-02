import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Node {
    private String item;
    private Node next;

    public Node(String newitem, Node node) {
        item = newitem;
        next = node;
    }

    public String getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setItem(String newitem) {
        item = newitem;
    }

    public void setNext(Node newnext) {
        next = newnext;
    }
}

class SList {
    protected Node head;

    public SList() {
        head = new Node(null, null);

    }

    public void insert_inc(String x) {
        Node prev = head;
        Node current = head.getNext();

        while (current != null && current.getItem().compareTo(x) < 0) {
            prev = current;
            current = current.getNext();
        }

        Node newNode = new Node(x, current);
        prev.setNext(newNode);
    }

    public void delete(String x) {
        Node prev = head;
        Node current = head.getNext();
        while (current != null) {
            if (current.getItem().equals(x)) {
                prev.setNext(current.getNext());
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public void print() {
        Node current = head.getNext();
        while (current != null) {
            System.out.print(current.getItem() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        SList list = new SList();

        try {
            String filepath = "C:\\test.txt"; // 절대 경로
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    list.insert_inc(token);
                }
                list.print(); // 리스트 출력
                String deleteword = br.readLine();
                if (deleteword != null) {
                    list.delete(deleteword);
                }
                line = br.readLine();
                list.print(); // 삭제 후 리스트 출력
                System.out.println("-------------------------------------------");

                list = new SList();

            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("파일을 읽는 동안 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
