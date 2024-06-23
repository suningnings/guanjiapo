package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.swing.JDialog;

import org.jfree.date.DateUtilities;

import cn.itheima.gjp.service.LedgerService;
import cn.itheima.gjp.tools.DateUtils;
import cn.itheima.gjp.tools.JFreeChartUtils;
import cn.itheima.gjp.view.AbstractShapeDialog;

public class ShapeController extends AbstractShapeDialog {
    public ShapeController(JDialog dialog) {
        super(dialog);
        initDialog();
    }
    LedgerService ledgerService = new LedgerService();
    @Override
    public List<String> getImagePaths() {
        // TODO Auto-generated method stub
        List<String> listPath = new ArrayList<String>();
        // 支出
        Double moneyPay = ledgerService.queryTotalMonetByParent("支出");
        Map<String, Double> mapPay = ledgerService.quarySumMoneyBySort("支出");
        String titlePay = "支出占比图（" + moneyPay + ")(" + DateUtils.getYear()+ "年）";
        JFreeChartUtils.pie(titlePay, mapPay, moneyPay, "pay.jpg");
        listPath.add("pay.jpg");
        // 收入
        Double moneyIn = ledgerService.queryTotalMonetByParent("收入");
        Map<String, Double> mapIn = ledgerService.quarySumMoneyBySort("收入");
        String titleIn = "收入占比图（" + moneyIn + ")(" + DateUtils.getYear() + "年）";
        JFreeChartUtils.pie(titleIn, mapIn, moneyIn, "in.jpg");
        listPath.add("in.jpg");
        return listPath;
    }

}