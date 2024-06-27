package cn.itheima.gjp.domain;

/*
 * 跟  gjp_sort对应的
 */
public class Sort {
    private int sid;
    private String sname;
    private String parent;
    private String sdesc;
    private String xinzen;

    public Sort() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Sort (int sid, String sname, String parent, String sdesc,String xinzen) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.parent = parent;
        this.sdesc = sdesc;
        this.xinzen= xinzen;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public String getXinzen() {
        return xinzen;
    }

    public void setXinjia(String xinzen) {
        this.xinzen = xinzen;
    }

    @Override
    public String toString() {
       return "Sort [sid=" + sid + ", sname=" + sname + ", parent=" + parent + ", sdesc=" + sdesc + ", xinzen=" + xinzen +"]";
    }

}