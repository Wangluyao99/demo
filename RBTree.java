package com.test.java;

public class RBTree<K extends Comparable<K>,V>{
    private static final boolean RED=true;
    private static final boolean BLACK=false;

    /**定义树根的引用*/
    private RBnode root;
    /**
     * 获取当前节点的父节点
     */
    private RBnode parentOf(RBnode node){
        if (node != null){
            return node.parent;
        }
        return null;
    }

    /**
     * 判断当前节点是否为红色
     */
    private boolean isRED(RBnode node){
        if (node != null){
            return node.color==RED;
        }
        return false;
    }

    /**
     * 判断当前节点是否为黑色
     */
    private boolean isBlack(RBnode node){
        if (node != null){
            return node.color==BLACK;
        }
        return false;
    }

    /**
     * 设置节点为红色
     */
    private void setRed(RBnode node) {
        if(node != null){
            node.color=RED;
        }
    }
    /**
     * 设置节点为黑色
     */
    private void setBlack(RBnode node) {
        if(node != null){
            node.color=BLACK;
        }
    }

    /**
     * 中序打印二叉树
     */
    public void inOrderPrint(){
        inOrderPrint(this.root);
    }

    private void inOrderPrint(RBnode node){
        if(node != null){
            inOrderPrint(node.left);
            System.out.println("key"+node.key+"value"+node.value);
            inOrderPrint(node.right);
        }
    }

    /**左旋*/
    private void leftRotate(RBnode x){
        RBnode y = x.right;
        //1、x的右子节点指向y的左子节点，将y的左子节点的父节点更新为x
        x.right=y.left;
        if(y.left !=null){
            y.left.parent=x;
        }
        //2、当x的父节点不为空时，更新y父节点为x的父节点，并判断x在父节点的左右子树，指定给y.
        if(x.parent != null){
            y.parent=x.parent;
            if(x==x.parent.left){
                x.parent.left=y;
            }else{
                x.parent.right=y;
            }
        }else {//说明原来x为根节点，此时更新y为根节点
            this.root = y;
            this.root.parent=null;
        }
        //3、将x的父节点更新为y，将y的左子节点更新为x.
        x.parent=y;
        y.left=x;
    }

    /**右旋*/
    private void rightRotate(RBnode y){
        RBnode x=y.left;
        //1、
        y.left=x.right;
        if(x.right != null) {
            x.right.parent= y;
        }
        //2、
        if(y.parent != null){
            x.parent=y.parent;
            if(y==y.parent.left){
                y.parent.left=x;
            }else {
                y.parent.right=x;
            }
        }else{
            this.root=x;
            this.root.parent=null;
        }
        //3、
        y.parent=x;
        x.right=y;
    }

    /**插入方法*/
    public void insert(K key,V value){
        RBnode node = new RBnode();
        node.setKey(key);
        node.setValue(value);
        node.setColor(RED);
        insert(node);
    }
    private void insert(RBnode node){
        //第一步查找当前node的父节点
        RBnode parent=null;
        RBnode x=this.root;

        while (x != null){
            parent=x;
            //cmp>0,说明node.key 大于 x.key,需要到x的右子树查找
            //cmp==0,说明node.key等于 x.key,需要进行替换操作
            //cmp<0,说明node.key 小于 x.key,需要到x的左子树查找
            int cmp=node.key.compareTo(x.key);
            if(cmp>0){
                x=x.right;
            }else if(cmp==0){
                x.setValue(node.getValue());
                return;
            }else {
                x=x.left;
            }
        }
        node.parent=parent;
        if(parent != null) {
            //判断node与parent的key谁大
            int cmp = node.parent.key.compareTo(parent.key);
            if(cmp>0){//node的key大，node放在parent的右边
                parent.right=node;
            }else {//node的key小，node放在parent的左边
                parent.left=node;
            }
        }else {
            this.root=node;
        }
        //需要调用修复红黑树平衡的方法
        insertFixUp(node);
    }

    private void insertFixUp(RBnode node) {
        this.root.setColor(RED);

        RBnode parent=parentOf(node);
        RBnode gparent=parentOf(parent);

        //情景四:插入节点的父节点为红色
        if(parent !=null && isRED(parent) ){
            //如果父节点是红色，一定存在爷爷节点
            RBnode uncle =null;
            if(parent==gparent.left){//父节点是爷爷节点的左子树
                uncle=gparent.right;

                //情景4.1：叔叔节点存在并且是红色（叔父双红）
                if (uncle != null && isRED(uncle)){
                    //叔父染黑，爷爷变红，下一轮处理
                    setBlack(parent); ;
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent) ;
                    return;
                }
                //情景4.2：叔叔不存在，或者是黑色
                    if(uncle==null && isBlack(uncle)){
                        //4.2.1: 插入节点是父节点的左子节点（LL双红），父节点变黑，爷爷节点变红并右旋
                        if (node ==parent.left){
                            setBlack(parent);
                            setRed(gparent); ;
                            rightRotate(gparent);
                            return;
                        }
                        //4.2.2:  插入节点是父节点的左子节点（LR双红）,以父节点左旋，做4.2.1操作
                        if(node==parent.right){
                            leftRotate(parent);
                            insertFixUp(parent);
                            return;
                        }
                    }
            }else {//父节点是爷爷节点的右子树
                uncle=gparent.left;
                //在右子树也会出现叔父双红的情况(4.1)
                if (uncle != null && isRED(uncle)) {
                    //叔父染黑，爷爷变红，下一轮处理
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFixUp(gparent);
                    return;
                }
                //情景4.3：叔叔节点不存在，或者黑色
                if(uncle ==null && isBlack(uncle)){
                    //4.3.1:插入节点为父节点右子节点，将父节点变黑，爷爷变红并左旋。
                    if(node == parent.right){
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return;
                    }
                    //4.3.2: 插入节点为父节点左子节点，父节点右旋，进行4.3.1操作
                    if(node==parent.left){
                        rightRotate(parent);
                        insertFixUp(parent);
                        return;
                    }
                }

            }
        }
    }

    static class RBnode<K extends Comparable<K>,V>{
        private RBnode parent;
        private RBnode left;
        private RBnode right;
        private boolean color;
        private K key;
        private V value;

        public RBnode(RBnode parent, RBnode left, RBnode right, boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }

        public RBnode() {
        }

        public RBnode getParent() {
            return parent;
        }

        public void setParent(RBnode parent) {
            this.parent = parent;
        }

        public RBnode getLeft() {
            return left;
        }

        public void setLeft(RBnode left) {
            this.left = left;
        }

        public RBnode getRight() {
            return right;
        }

        public void setRight(RBnode right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
