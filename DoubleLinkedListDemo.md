package DoubleLinkedList;




public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(4, "零充", "豹子");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        /*doubleLinkedList.addHeroNode(hero1);
        doubleLinkedList.addHeroNode(hero2);
        doubleLinkedList.addHeroNode(hero3);
        doubleLinkedList.addHeroNode(hero4);
        doubleLinkedList.addHeroNode(hero5);
        doubleLinkedList.addHeroNode(hero4);*/

        doubleLinkedList.addorderby(hero4);
        doubleLinkedList.addorderby(hero2);
        doubleLinkedList.addorderby(hero1);
        doubleLinkedList.addorderby(hero5);
        doubleLinkedList.addorderby(hero3);


        doubleLinkedList.updata(hero5);

        doubleLinkedList.deletenode(3);




        doubleLinkedList.list();


    }
}
class DoubleLinkedList {
    //初始化一个头节点，不要动这个头节点
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //显示链表，遍历
    public void list() {
        if (head.next == null) {
            System.out.println("该链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
    //顺序添加节点到双向链表
    public void addorderby(HeroNode2 heroNode2){
        HeroNode2 temp = head;
        while(true){
            if(temp.next == null){
                temp.next = heroNode2;
                heroNode2.pre = heroNode2;
            }
            if(temp.next.no > heroNode2.no){
                heroNode2.next = temp.next;
                temp.pre = heroNode2;
                heroNode2.pre = temp;
                temp.next = heroNode2;
                break;

            }else if(temp.next.no == heroNode2.no){
                System.out.println("该节点已存在");
                return;
            }
            temp = temp.next;
        }











    }

    //添加节点到双向链表
    public void addHeroNode(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while(true){
            if(temp.next == null) {
                break;
            }
            if(temp.next.no == heroNode.no){
                System.out.println("节点插入失败，已有该节点");
                return;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;

    }

    //修改节点的信息，根据no编号来修改
    public void updata(HeroNode2 heroNode){
        if(head.next == null){
            System.out.println("该链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;


        }
        if(flag){
            temp.name = heroNode.name;
            temp.nikename = heroNode.nikename;
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }


    }
    //删除节点
    public void deletenode(int no){
        if(head.next == null){
            System.out.println("该链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                System.out.println("没有找到");
                break;
            }
            if(temp.no == no){
                temp.pre.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }

                System.out.printf("删除节点%d成功\n",no);
                break;
            }
            temp = temp.next;
        }


    }














}

class HeroNode2{
    public int no;
    public String name;
    public String nikename;
    public HeroNode2 next;
    public HeroNode2 pre;
    //构造器
    public HeroNode2(int no,String name,String nikename){
        this.no = no;
        this.name = name;
        this.nikename = nikename;
    }

//重写tostring方法


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikename='" + nikename + '\'' +
                '}';
    }
}

