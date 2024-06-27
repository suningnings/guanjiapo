package cn.itheima.gjp.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;


import cn.itheima.gjp.domain.Ledger;
import cn.itheima.gjp.tools.DateChooser;
import cn.itheima.gjp.tools.DateUtils;
import cn.itheima.gjp.tools.GUITools;
import cn.itheima.gjp.tools.ListTableModel;


public abstract class AbstractxinMngDialog extends JDialog {
    protected JTable ledgerDataTable = new JTable();// 账务数据列表
    protected JTextField yusuan = new JTextField("0.0");//金额文本框
    protected JLabel zongzhichu = new JLabel("总支出：0.00元");
    protected JLabel shengyu = new JLabel("本月经费还有：0.00元");
    private JButton chaxun = new JButton("查　询");// 查询按钮
    private JButton guanbi = new JButton("关闭");
    // 金额


    public AbstractxinMngDialog(JFrame frame) {
        super(frame, true);
        initDialog();
    }
    protected void initDialog() {
        this.init();
        this.addComponent();
        addListener();
    }

    private void init() {
        this.setResizable(false);// 设置窗体大小不可变
        this.setTitle("预算管理");// 设置标题
        this.setSize(680, 400);// 设置大小
        GUITools.center(this);// 设置居中
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);// 设置关闭按钮
    }

    private void addComponent() {
        // 设置标签标题
        JLabel titleLabel = new JLabel();
        titleLabel.setFont(new Font("宋体", Font.ITALIC, 18));
        titleLabel.setText("账务管理");
        titleLabel.setBounds(280, 20, 165, 20);
        this.add(titleLabel);

        // 查询按钮
        chaxun.setBounds(480, 70, 100, 28);
        this.add(chaxun);

        // 滚动面板
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 100, 620, 160);
        setTableModel(null);

        ledgerDataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
        ledgerDataTable.getTableHeader().setReorderingAllowed(false);// 列不能移动

        scrollPane.setViewportView(ledgerDataTable);
        this.add(scrollPane);

        ledgerDataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 单选
        ledgerDataTable.getTableHeader().setReorderingAllowed(false);// 列不能移动

        scrollPane.setViewportView(ledgerDataTable);
        this.add(scrollPane);


        // 总支出标签
        this.zongzhichu.setBounds(530, 260, 120, 28);
        this.add(this.zongzhichu);
        zongzhichu.setForeground(new Color(255, 0, 0));

        //剩余经费标签
        this.shengyu.setBounds(130,260,220,28);
        this.add(this.shengyu);
        shengyu.setForeground(new Color(150, 0, 0));

        // 关闭按钮
        guanbi.setBounds(570, 330, 80, 28);
        this.add(guanbi);

        // 金额
        JLabel moneyLabel = new JLabel("本月预算：");
        moneyLabel.setBounds(30, 70, 100, 28);
        yusuan.setBounds(90, 70, 100, 28);
        yusuan.setHorizontalAlignment(JTextField.RIGHT);// 文本右对齐
        this.add(moneyLabel);
        this.add(this.yusuan);
    }
    protected void setTableModel(List<Ledger> ledgerList) {
        String[] colNames = new String[] { "ID", "收/支", "分类", "金额", "账户", "创建时间", "说明" };
        String[] propNames = new String[] { "lid", "parent", "sname", "money", "account", "createtime", "ldesc" };
        if (ledgerList == null || ledgerList.size() == 0) {
            ledgerDataTable
                    .setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null },
                            { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
                            { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
                            { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
                            { null, null, null, null, null, null, null } }, colNames));
            ledgerDataTable.setEnabled(false);
            return;
        }
        try {
            ledgerDataTable.setModel(new ListTableModel<Ledger>(ledgerList, Ledger.class, colNames, propNames));
            ledgerDataTable.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void addListener() {

        chaxun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                chaxunyue();
            }
        });

        guanbi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AbstractxinMngDialog.this.dispose();
            }
        });






            }
    public abstract void chaxunyue();


}






