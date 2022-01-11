package stack;

/**
 * @author glows777
 * 用栈模拟实现浏览器的前进后退功能
 * 用两个栈维护
 * 当前的页面存放于后退栈栈顶
 * 每一次后退，相当于后退栈出栈，而前进栈将后退栈出栈的元素压栈
 * 每一次前进，相当于前进栈出栈，而后退栈将前进栈出栈的元素压栈
 * 每一次打开新的页面，前进栈必须清空，这样才可以实现符合事实的浏览器前进后退
 */
public class SampleBrowser {

    /** 测试 */
    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("https://www.baidu.com");
        browser.open("https://www.wechat.com/");
        browser.open("https://www.sina.com/");
//        browser.checkCurrentPage();
        browser.goBack();
//        browser.checkCurrentPage();
        browser.goBack();
//        browser.checkCurrentPage();
        browser.goForward();
//        browser.checkCurrentPage();
        browser.goForward();
//        browser.checkCurrentPage();
        browser.open("https://www.qq.com");
//        browser.checkCurrentPage();
//        browser.goForward();
        browser.goBack();
//        browser.checkCurrentPage();
        browser.goForward();
//        browser.checkCurrentPage();
        browser.goBack();
//        browser.checkCurrentPage();
        browser.goBack();
//        browser.checkCurrentPage();
        browser.goBack();
//        browser.checkCurrentPage();
        browser.goBack();
        browser.checkCurrentPage();
    }

    private String currentPage;
    private LinkedListBasedStack backStack;
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    public void open(String url) {
        this.backStack.push(url);
        forwardStack.clear();
        this.currentPage = url;
    }

    public boolean canGoBack() {
        return backStack.size() > 0;
    }
    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }


    public String goBack() {
        if (this.canGoBack()) {
            String backUrl = this.backStack.pop();
            this.forwardStack.push(backUrl);
            this.currentPage = backStack.getTopData();
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public String goForward() {
        if (this.canGoForward()) {
            String forwardUrl = this.forwardStack.pop();
            backStack.push(forwardUrl);
            this.currentPage = backStack.getTopData();
            return forwardUrl;
        }
        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }


    public static class LinkedListBasedStack {
        private int size;
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        public void clear() {
            this.top = null;
            this.size = 0;
        }
        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        public String pop() {
            Node popNode = this.top;
            if (popNode == null) {
                System.out.println("Stack is empty.");
                return null;
            }
            this.top = popNode.next;
            if (this.size > 0) {
                this.size--;
            }
            return popNode.data;
        }

        public String getTopData() {
            if (this.top == null) {
                return null;
            }
            return this.top.data;
        }

        public int size() {
            return this.size;
        }
        public void print() {
            System.out.println("Print stack:");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.print(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

        public static class Node {

            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }

    }
}

