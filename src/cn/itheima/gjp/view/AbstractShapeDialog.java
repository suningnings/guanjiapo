package cn.itheima.gjp.view;

import java.awt.Dialog;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import cn.itheima.gjp.tools.GUITools;

public abstract class AbstractShapeDialog extends JDialog {

    public AbstractShapeDialog(Dialog owner) {
        super(owner);
    }
    public abstract List<String> getImagePaths();
    protected void initDialog() {
        this.addComponent();
        this.init();
    }
    private void addComponent() {
        // TODO Auto-generated method stub
        List<String> imagePaths = getImagePaths();
        if (imagePaths == null) {
            return;
        }
        JPanel panel = new JPanel();
        this.add(panel);
        for (String path : imagePaths) {
            try {
                Image image = ImageIO.read(new File(path));
                panel.add(new JLabel(new ImageIcon(image)));
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
    private void init() {
        // TODO Auto-generated method stub
        this.pack();
        GUITools.center(this);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}