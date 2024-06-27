package cn.itheima.gjp.web;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cn.itheima.gjp.domain.Ledger;
import cn.itheima.gjp.domain.Sort;
import cn.itheima.gjp.service.LedgerService;
import cn.itheima.gjp.service.SortService;

import cn.itheima.gjp.view.AbstractSortMngDialog;
import cn.itheima.gjp.view.AbstractxinMngDialog;

public class xinMngDialog extends AbstractxinMngDialog {
    double payMoney = 0;

    LedgerService ls = new LedgerService();

    /*
     * 管理界面 构造方法
     *    带参构造  创建当前对话框用的  传递的是指定的父窗口
     */
    public xinMngDialog(JFrame frame) {

        super(frame);
        /**
         * 1:构造 弹出窗口的时候 就应该查询数据库
         *   所以 调用查询的方法写到 当前的这个构造中
         * 2:异常的处理 就不要再抛了
         *    自行处理 try..catch
         */
        try {
            // 查询所有账务信息
            queryAllLedger();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void queryAllLedger() throws SQLException {
        // 需要查询到所有的账务信息 并展示
        // LedgerService中 存在一个方法 queryAllLedger 完成了 查询所有账务信息的操作
        // 创建LedgerService对象

        // 查询所有账务
        List<Ledger> allLedger = ls.queryAllLedger();

        System.out.println(allLedger);

        // 所有的ledger对象设置到 下拉框中 ledgerDataTable
        // 将数据 设置到 ledgerDataTable 下拉框中
        // 其实 该类的父类 中有个方法 setTableModel(List<Ledger> ledgers)
        setTableModel(allLedger);

        // 还应在展示的时候 完成 总收入 总支出的计算

        // 求累加之和 遍历集合

        // 遍历集合 List<Ledger> allLedger
        // 遍历之前 定义两个变量 分贝存储 收入/支出 的累加结果
        // 总支出 求和变量
        for (int i = 0; i < allLedger.size(); i++) {
            // 获取每一个 Ledger对象
            Ledger ledger = allLedger.get(i);
            // 获取 该条账务信息的 父分类 要么是收入 要么是支出
            String parent = ledger.getParent();
            // 获取 该条账务信息的 金额
            double money = ledger.getMoney();


            if (parent.equals("支出")) {
                // 总支出 累加
                payMoney += money;
            }
        }
        System.out.println(payMoney);
        zongzhichu.setText("总支出:" + payMoney);


    }

    //还缺一个查询的描述
    public void chaxunyue() {
        String qian = yusuan.getText();
        double temp = Double.parseDouble(qian);
        System.out.println((temp - payMoney));
        if ((temp - payMoney) < 0) {
            shengyu.setText("这点钱不够你花");
        } else {
            shengyu.setText("剩余经费还有：" + (temp - payMoney));
        }
    }
}
